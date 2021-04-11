一、id sex chinese_s math_s
0 0 70 50
1 0 90 70
2 1 80 90
1、男女各自语文第一名（0:男，1:女）
2、男生成绩语文大于80，女生数学成绩大于70

create table if not exists student(
id int,
sex string,
chinese_s double,
math_s double
)
row format delimited fields terminated by ' '
lines terminated by '\n'
stored as textfile
;

load data local inpath '/root/hivedata/student.txt' into table student;

1.
select
id,
sex,
chinese_s
from
(
select
id,
sex,
chinese_s,
row_number() over(partiton by sex order by chinese_s desc) ord
from
student) tmp
where ord=1
;

select
*
from
student
where (sex='0' and chinese_s>80) or (sex='1' and math_s>70)
;


二、每个用户连续登陆的最大天数？
uid,date
1,2019-08-01
1,2019-08-02
1,2019-08-03
2,2019-08-01
2,2019-08-02
3,2019-08-01
3,2019-08-03
4,2019-07-28
4,2019-07-29
4,2019-08-01
4,2019-08-02
4,2019-08-03
结果如下
uid cnt_days
1 3
2 2
3 1
4 3

create table if not exists temp.test(
uid string,
date1 string
)
row format delimited fields terminated by ','
lines terminated by '\n'
stored as textfile
;

load data local inpath '/home/liujian1/data3.txt' into table temp.test;
load data local inpath '/home/liujian1/data3.txt' overwrite into table temp.test;

with t as (
select
uid,tmp,count(1) as days
from
(select
      uid,date,
      date_sub(date1,row_number() over(partition by uid order by date1) ) as tmp
      from
temp.test) t group by uid,tmp)
select
uid,max(days) as days
from t group by uid;


三、订单及订单类型行列互换
order_id order_type order_time
111 N 10:00
111 A 10:05
111 B 10:10
是用hql获取结果如下：
order_id order_type_1 order_type_2 order_time_1 order_time_2
111 N A 10:00 10:05
111 A B 10:05 10:10



select
order_id,order_type,order_time,order_type_1,order_time_1
from (select
      order_id,
      order_type,
      order_time,
      lead(order_type,1,'') over(partition by order_id order by order_time) as order_type_1,
      lead(order_time,1,'') over(partition by order_id order by order_time) as order_time_1
      from
      table) t where t.order_type_1 != ''
;

四、每个店铺的当月销售额和累计到当月的总销售额

五、编写sql语句实现每班前三名，分数一样并列，同时求出前三名
  按名次排序的一次的分差

Stu_no class score
1 1901 90
2 1901 90
3 1901 83
4 1901 60
5 1902 66
6 1902 23
7 1902 99
8 1902 67
9 1902 87

create table if not exists stu(
stu_no string,
class string,
score int
)
row format delimited fields terminated by ' '
lines terminated by '\n'
stored as textfile
;

select
Stu_no,class,score,
diff
from(select
     Stu_no,class,score,
     (score - lag(score,1,0) over(partition by class order by score desc)) as diff,
     rank() over(partition by class order by score desc) as rk
     from
     stu) t where rk<= 3;


六、hive 编写连续7天登录的总人数
Uid dt login_status(1登录成功,0异常)
1 2019-07-11 1
1 2019-07-12 1
1 2019-07-13 1
1 2019-07-14 1
1 2019-07-15 1
1 2019-07-16 1
1 2019-07-17 1
1 2019-07-18 1
2 2019-07-11 1
2 2019-07-12 1
2 2019-07-13 0
2 2019-07-14 1
2 2019-07-15 1
2 2019-07-16 0
2 2019-07-17 1
2 2019-07-18 0
3 2019-07-11 1
3 2019-07-12 1
3 2019-07-13 1
3 2019-07-14 1
3 2019-07-15 1
3 2019-07-16 1
3 2019-07-17 1
3 2019-07-18 1

create table if not exists login(
uid string,
dt string,
login_status int
)
row format delimited fields terminated by ' '
lines terminated by '\n'
stored as textfile
;

with table as (select
           Uid,dt,
           date_sub(dt,row_number() over (partition by Uid order by dt)) tmp
           from(select
                *
                from login where login_status = '1') t)


select
count(distinct uid) as num
from (select
      Uid,tmp
      from table group by Uid,tmp having count(1) >= 7;)

七、 求出每个栏目的被观看次数及累计观看时长
Uid channl min
1 1 23
2 1 12
3 1 12
4 1 32
5 1 342
6 2 13
7 2 34
8 2 13
9 2 134

create table if not exists video(
uid string,
channl string,
min int
)
row format delimited fields terminated by ' '
lines terminated by '\n'
stored as textfile
;

select
count(1) as cnt,
sum(min) as video
from video group by channl


八、编写sql实现每个用户截止到每月为止的最大单月访问次数和累计到该月的总访问次数
userid,month,visits
A,2015-01,5
A,2015-01,15
B,2015-01,5
A,2015-01,8
B,2015-01,25
A,2015-01,5
A,2015-02,4
A,2015-02,6
B,2015-02,10
B,2015-02,5
A,2015-03,16
A,2015-03,22
B,2015-03,23
B,2015-03,10
B,2015-03,1

create table if not exists visits(
id string,
month string,
visits int
)
row format delimited fields terminated by ','
lines terminated by '\n'
stored as textfile
;

with a as
 (
 select
 userid,month,sum(visits) as visits
 from visits group by userid,month
)

select
userid,month,
max(visits) over(partition by userid order by month),
sum(visits) over(partition by userid order by month)
from a



九、
SELECT adid, count(1)
FROM pageAds LATERAL VIEW explode(adid_list) adTable AS adid
GROUP BY adid;

十、explode

一班 小a,小B,小c 88,80,90
二班 小c,小d 100,16
三班 小e 7

create table if not exists temp.test(
id string,
banji string,
score string
)
row format delimited fields terminated by ' '
lines terminated by '\n'
stored as textfile
;

load data local inpath '/home/liujian1/data4.txt' overwrite into table temp.test;

select
id,banji1,score1
from temp.test
lateral view posexplode(split(banji,',')) t1 as pos,banji1
lateral view posexplode(split(score,',')) t2 as pos,score1
where t1.pos = t2.pos;


create table if not exists temp.test(
oid string,
uid string,
d string,
amt int
)
row format
delimited fields terminated by ','
lines terminated by '\n'
stored as textfile
;

-- 求每个用户top3交易金额的订单

select
uid,
oid
from (select
oid,
uid,
row_number() over(partition by uid order by amount desc ) rk
from temp.test) t where rk <= 3;












































