package com.javastudy._面向对象;

/**
 * @author : 刘剑
 * @date : 2020/10/28 10:20 上午
 * @description
 */
public class Person {

    private String name;
    private int age;

//    public Person() {
//    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public void say(){
        System.out.println(name+"..."+age);
    }
    public void papapa(){
        System.out.println(name+"   pa pa pa");
    }
}
