

一、#### 留存模型
https://bbs.csdn.net/topics/392435005

act_user_info
用户ID (user_id) 和 登录日期 (login_time)



---------方式1
select
a.user_id
count(distinct a.user_id)  as '活跃用户数',
count(distinct b.user_id)  as '一日留存',
count(distinct c.user_id)  as '三日留存',
count(distinct d.user_id)  as '七日留存',

from
act_user_info a
left join act_user_info b on a.user_id = b.user_id and b.login_time = a.login_time + 1
left join act_user_info c on a.user_id = c.user_id and c.login_time = a.login_time + 3
left join act_user_info c on a.user_id = d.user_id and d.login_time = a.login_time + 7
group by a.user_id

-----------方式2

select
a.login_time,
a.r_type,
count(distinct a.user_id)
from
(
select
login_time,
user_id,
concat(datediff(cur,login_time),'d') as r_type
from act_user_info where login_time in (date_sub(cur,7),date_sub(cur,3),date_sub(cur,1))) a
join
(
select
user_id
from act_user_info where login_time = cur) b on a.user_id = b.user_id
group by a.login_time,a.r_type
--- 方式3
select a.登陆时间,count(distinct a.用户id) as 活跃用户数,
count(distinct when 时间间隔=1 then 用户id else null end) as  次日留存数,
count(distinct when 时间间隔=1 then 用户id else null end) as  次日留存数 / count(distinct a.用户id) as 次日留存率,
count(distinct when 时间间隔=3 then 用户id else null end) as  三日留存数,
count(distinct when 时间间隔=3 then 用户id else null end) as  三日留存数 / count(distinct a.用户id) as 三日留存率,
count(distinct when 时间间隔=7 then 用户id else null end) as  七日留存数,
count(distinct when 时间间隔=7 then 用户id else null end) as  七日留存数 / count(distinct a.用户id) as 七日留存率
 from
(select *,timestampdiff(day,a.登陆时间,b.登陆时间) as 时间间隔
from
(select a.用户id,a.登陆时间,b.登陆时间
from 用户行为信息表 as a
left join 用户行为信息表 as b
on a.用户id = b.用户id
where a.应用名称= '相机') as c
) as d
group by a.登陆时间;
--查询


select
p_day,
sum(if(r_type= '',uv,0)) as
sum(if(r_type= '',uv,0)) as
sum(if(r_type= '',uv,0)) as
sum(if(r_type= '',uv,0)) as
sum(if(r_type= '',uv,0)) as
sum(if(r_type= '',uv,0)) as
from
tmp
group by p_day;


-- ================================== ks=====================
-- 题一、
--uid   bigint
--amount  decimal
--前提：uid唯一  20亿条
--求top10000金额最大的
--输出uid,amount
-- 1、分桶求top10000
with a as (select
uid,
amount,
row_number() over (partition by (uid%100) order by amount desc ) as rk
from
t),
 b as (
select
uid,
amount,
row_number() over (order by amount desc ) as rk
from a where rk <= 10000
)
-- 取全局的top10000
select
uid,
amount from b where rk <= 10000;

-- 题二、
--uid  year amount
-- 前提： uid,year唯一     20亿条
--求：
--连续5年以上的充值的用户,以及连续充值的金额和历史总金额
--输出uid，year，连续充值年份，连续的充值金额，历史总金额

with a as (
select
uid,
year,
amount,
(year - row_number () over(partition  by uid  order  by year)) as rk,
sum(amount) over(partition  by uid) as all_amount
from t
),
 b as (
select
uid,
year,
amount,
all_amount,
count(rk) over(partition by rk) as cnt
from  a
 )
 -- 寻找连续充值5年的用户的所有数据
 c as (
 select
uid,
year,
amount,
all_amount,
cnt
from b where cnt >=5
 )

 select
 uid,
year,
cnt,-- 连续充值的年份数
sum(amount) over(partition  by uid) as amount, -- 连续充值金额
all_amount --历史总金额
 from
 c



-- ---------------lc
with a as (
select
id,visit_date,people,
(id - row_number() over (order by id)) as k
from t where people > 100
t
),
-- 求k的个数
b as (
select
id,visit_date,people,
count(k) over(partition by k) as cnt
from a
)
select
id,visit_date,people
from b where cnt >=3;


-- https://blog.csdn.net/PIPJIN961111/article/details/102598747
-- 1、编写连续7天登录的总人数
with a as (select
date_sub(dt,row_number() over(partition by uid order by dt)) as k
from
t where login_status = 1),
b as (select
uid,k
from a group by uid,k having count(uid) >= 7)
select count(distinct uid) as cnt from b;

-- 2、编写 sql 句实现每班前三名，分数一样并列，同时求出前三名
with a as (
select
Stu_no,
class,
score,
rank() over(partition by class order by score desc) as rk
from
t
)
select
Stu_no,
class,
score from  where rk <= 3;

-- 每个店铺的当月销售额和累计到当月的总销售额
-- 店铺,月份,金额
with a as (select
shopid,month,sum(amount) as amount
from t group by shopid,month)
select
shopid,month,amount,
sum(amount) over(partition by shopid order by amount) as amt
from
a

-- 订单及订单类型行列互换
--order_id order_type order_time
--111 N 10:00
--111 A 10:05
--111 B 10:10

with a as (
select
order_id,
order_type,
order_time,
lead(order_type) over (partition by order_id order by order_time) as order_type1,
lead(order_time) over (partition by order_id order by order_time) as order_time1,
from t)
select
*
from a where order_type1 is not null and order_time1 is not null;


-- 某APP每天访问数据存放在表access_log里面
--包含日期字段ds,用户类型字段user_type，用户账号user_id,用户访问时间log_time,请使用hive的hql语句实现如下需求：
--(1)、每天整体的访问UV、PV?
--(2)、每天每个类型的访问UV、PV?
--(3)、每天每个类型中最早访问时间和最晚访问时间?
--(4)、每天每个类型中访问次数最高的10个用户?

-- 1
select
ds,
count(distinct  user_id) as uv,
count(user_id) as pv
from
access_log group by ds

-- 2
select
ds,
user_type
count(distinct  user_id) as uv,
count(user_id) as pv
from
access_log group by ds,user_type

-- 3
select
ds,
user_type,
min(log_time) as earlest,
max(log_time) as lastest
from
access_log group by ds,user_type

--4
with a as (
select
ds,
user_type,
user_id,
count(1) as cnt
from
access_log group by ds,user_type,user_id
),
b as (
select
ds,
user_type,
user_id,
row_number() over(partition by ds,
user_type,
user_id order  by cnt desc) rk
from a
)
select ds,
user_type,
user_id from b  where rk <= 10 ;


--id sex chinese_s math_s
--0 0 70 50
--1 0 90 70
--2 1 80 90
--1、男女各自语文第一名（0:男，1:女）
--2、男生成绩语文大于80，女生数学成绩大于70
with a as(
select
sex,chinese_s
row_number () over(partition by sex order by chinese_s desc) as rk
from t
)
select
sex,chinese_s
from
a where rk = 1;

select
*
from where (sex = 0 and chinese_s > 80) or (sex = 1 and math_s > 70)


--数据：
--t1表
--uid tags
--1 1,2,3
--2 2,3
--3 1,2
--编写sql实现如下结果：
--uid tag
--1 1
--1 2
--1 3
--2 2
--2 3
--3 1
--3 2

select
uid,
tag
from
t lateral view explode(tags) t as tag


-- 1.2.4 用户标签连接查询
--数据：
--T1表:
--Tags
--1,2,3
--1,2
--2,3
--T2表:
--Id lab
--1 A
--2 B
--3 C
--根据T1和T2表的数据，编写sql实现如下结果：
--ids tags
--1,2,3 A,B,C
--1,2 A,B
--2,3 B,C

with a as (select
Tags,
tag
from
t lateral view explode(split(Tags,',')) tmp as tag)
b as (
Tags,
lab
select
from a join t on a.tag = t.Id
)
select
concat_ws(',',collect_list(lab))
from b group Tags

-- 字符串a,b,c转数组 split('a,b,c',",")
-- 数组转化为字符串 concat_ws(",",collect_list(lab))

-- 1.2.6 用户标签行列互换
--数据：
--t1表
--uid name tags
--1 goudan chihuo,huaci
--2 mazi sleep
--3 laotie paly
--编写sql实现如下结果
--uid name tag
--1 goudan chihuo
--1 goudan huaci
--2 mazi sleep
--3 laotie paly

select
uid,
name,
tag
from
t lateral view explode(split(tags,",")) tmp as tag

-- 1.2.7 hive实现词频统计
--数据：
--t1表：
--uid contents
--1 i|love|china
--2 china|is|good|i|i|like
--统计结果如下,如果出现次数一样，则按照content名称排序：
--content cnt
--i 3
--china 2
--good 1
--like 1
--love 1
--is 1

select
ct,count(1) as cnt
from
t lateral view explode(split(contents,'|')) tmp as ct
group by ct order by cnt desc;


-- 1.2.8 课程行转列
--数据：
--t1表
--id course
--1,a
--1,b
--1,c
--1,e
--2,a
--2,c
--2,d
--2,f
--3,a
--3,b
--3,c
--3,e
--根据编写sql，得到结果如下(表中的1表示选修，表中的0表示未选修)：
--id a b c d e f
--1 1 1 1 0 1 0
--2 1 0 1 1 0 1
--3 1 1 1 0 1 0

select
id,
sum(case when course = 'a' then 1 else 0 end) as a,
sum(case when course = 'b' then 1 else 0 end) as b,
sum(case when course = 'c' then 1 else 0 end) as c,
sum(case when course = 'd' then 1 else 0 end) as d,
sum(case when course = 'e' then 1 else 0 end) as e,
sum(case when course = 'f' then 1 else 0 end) as f
from
t group by id


-- https://mp.weixin.qq.com/s?__biz=MzAxMTMwNTMxMQ==&mid=2649248845&idx=1&sn=b8e5a123fcd4cd54cf1f180f3e7641ec&chksm=835fdc7db428556b6c47f3483ee46cfc349a2ac42dd5db25dcb54d49a1785cdde81ba4430396&scene=21#wechat_redirect
-- 1.查询2019年Q1季度，不同性别，不同年龄的成交用户数，成交量及成交金额
-- 2.2019年1-4月产生订单的用户，以及在次月的留存用户数

select
u.sex,u.age,
count(distinct uid) as u,
count(orderid) as o,
sum(amount) as a
from
(select
orderid,uid,amount
from order where date_formate(o.date,'yyyy-MM') between '2019-01' and '2019-03') a
join (
select uid,sex,age from user
) u on a.uid = u.uid group by u.sex,u.age

with a as(select
domain,
url,
pv,
row_number() over(partition by domain order by pv desc) as rk
from t)
select
domain,url
from a where rk <= 2000














