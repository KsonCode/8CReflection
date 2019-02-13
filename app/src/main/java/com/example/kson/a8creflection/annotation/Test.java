package com.example.kson.a8creflection.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){

        //获取类的注解
        Class c = User.class;
        //通过类类型对象，字节码对象，获取注解对象
        MyAnotation myAnotation = (MyAnotation) c.getAnnotation(MyAnotation.class);
        if (myAnotation!=null){
            System.out.println(myAnotation.name());
        }


        //获取属性的注解
        try {
            Field field = c.getField("name");
            MyAnotation myAnotation1 = field.getAnnotation(MyAnotation.class);
            System.out.println(myAnotation1.name());

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
            Method method = c.getMethod("fun",String.class,int.class,int.class);
            MyAnotation myAnotation1 = method.getAnnotation(MyAnotation.class);
            if (myAnotation1!=null){
                myAnotation1.name();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
