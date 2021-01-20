package com.javastudy._面向对象;

/**
 * @author : 刘剑
 * @date : 2020/10/28 10:17 上午
 * @description
 */
public class Mytest {

    public static void main(String[] args) throws Exception{
//        Class clazz=Class.forName("com.yidian.data.cjv.utils.Person");
////        Person p=(Person)clazz.newInstance();    //通过无参构造创建对象
////        p.say();
//        Constructor c=clazz.getConstructor(String.class,int.class);//获取有参构造
//        Person p=(Person) c.newInstance("sanmao",12);    //通过有参构造创建对象
//        p.say();x
        Human p = new Person1("ZHANGSAN");
        p.print();
    }


}
