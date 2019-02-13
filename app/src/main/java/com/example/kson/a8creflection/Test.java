package com.example.kson.a8creflection;

import com.example.kson.a8creflection.entity.PersonEntity;
import com.example.kson.a8creflection.entity.Son;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] a){
        //第一种
         Class c1 = PersonEntity.class;

         //第二种
        PersonEntity personEntity = new PersonEntity();
        Class c2 = personEntity.getClass();

        //第三种
        try {
            Class c3 = Class.forName("com.example.kson.a8creflection.entity.PersonEntity");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //获取构造器
        try {
            Constructor constructor = c1.getConstructor(null);
            PersonEntity personEntity1 = (PersonEntity) constructor.newInstance(null);
//            personEntity1.fun();



            //获取构造器
//            Constructor constructor1 = c1.getDeclaredConstructor(String.class,int.class);
            Constructor constructor1 = c1.getDeclaredConstructor(new Class[]{String.class,int.class});
             constructor1.setAccessible(true);//强制访问，开通权限
            //通过构造器创建对象
            PersonEntity personEntity2 = (PersonEntity) constructor1.newInstance("宽松",100);
//            personEntity2.fun();


            //获取域，成员变量
            Field field = c1.getField("age");
//            field.set(new PersonEntity(),99);//不能直接new
//            field.set(PersonEntity.class.newInstance(),99);
            PersonEntity personEntity3 = (PersonEntity) constructor.newInstance(null);
//            field.set(personEntity3,99);
//            personEntity3.fun();


//            Field field1 = c1.getDeclaredField("name");
//            field1.setAccessible(true);
//
//            field1.set(personEntity3,"kson");
//            personEntity3.fun();

            //获取方法
            Method method = c1.getMethod("fun" ,null);
            //执行方法
            method.invoke(personEntity3,null);

            Method method1 = c1.getDeclaredMethod("fun1", String.class, int.class, String.class);
            method1.setAccessible(true);
            method1.invoke(personEntity3,"k",99,"s");


            new Son().f();













        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
