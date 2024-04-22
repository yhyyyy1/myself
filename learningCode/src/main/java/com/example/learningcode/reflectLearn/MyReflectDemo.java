package com.example.learningcode.reflectLearn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MyReflectDemo {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        // 获取class文件
//        // 1. Class.forName();
//        Class clazz = Class.forName("com.example.learningcode.reflectLearn.Student");
//        System.out.println(clazz);
//
//
//        // 2.
//        Class clazz2 = Student.class;
//        System.out.println(clazz2);
//
//        // 3.
//        Student student = new Student("yhy",21);
//        Class clazz3 = student.getClass();
//        System.out.println(clazz2);

//        // 获取class的内容
//        Class clazz = Class.forName("com.example.learningcode.reflectLearn.Student");
//        System.out.println("public 构造方法如下");
//        Constructor[] cons = clazz.getConstructors();
//        for (Constructor con : cons) {
//            System.out.println(con);
//        }
//        System.out.println("所有 构造方法如下");
//        Constructor[] consDeclared = clazz.getDeclaredConstructors();
//        for (Constructor con : consDeclared) {
//            System.out.println(con);
//        }
//
//        System.out.println("单个 构造方法如下");
//        Constructor conSingle = clazz.getDeclaredConstructor();
//        System.out.println(conSingle);
//        Constructor conSingle2 = clazz.getDeclaredConstructor(String.class);
//        System.out.println(conSingle2);
//        Constructor conSingle3 = clazz.getDeclaredConstructor(String.class, int.class);
//        System.out.println(conSingle3);
//
//        Parameter[] parameters = conSingle3.getParameters();
//        for (Parameter parameter : parameters) {
//            System.out.println(parameter);
//        }

        // 获取 Field的内容
        Class clazz = Class.forName("com.example.learningcode.reflectLearn.Student");

        Student s = new Student();
        Constructor conSingle = clazz.getDeclaredConstructor();
        System.out.println(conSingle);

    }
}
