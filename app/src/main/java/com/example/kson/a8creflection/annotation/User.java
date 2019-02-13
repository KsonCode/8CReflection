package com.example.kson.a8creflection.annotation;

@MyAnotation(name = "k",age = 99)
public class User {

    @MyAnotation(name = "name",age = 100)
    public String name;
    public int age;

    @MyAnotation(name = "212",age = 123)
    public void fun(@FieldAnotation("name") String name,int age,int h){

    }
}
