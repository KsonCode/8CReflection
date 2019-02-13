package com.example.kson.a8creflection.entity;

public class PersonEntity {
    private String name;
    public int age;


    public PersonEntity(){

        System.out.println("无参构造器");

    }

    private PersonEntity(String name,int age){

        System.out.println("私有构造器，name="+name);

    }



    public void fun(){

        System.out.println("age:"+age+" name:"+name);

        System.out.println("fun");

    }
    public void fun3(){

        System.out.println("age:"+age+" name:"+name);

        System.out.println("fun");

    }

    private void fun1(String name,int age,String s){

        System.out.println("私有fun1方法：name===="+name);

    }

}
