package com.xiaor.stage3.reflection_.access_private_;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xiaoR
 * @version 1.0
 * @date 2025/8/19
 * @description 演示通过反射机制创建实例
 */
public class ReflectCreateInstance_ {
    public static void main(String[] args) throws ClassNotFoundException {

        // 1. 获取User类的Class对象
        Class<?> userClass = Class.forName("com.xiaor.stage3.reflection_.access_private_.User");

        // 2. 通过public的无参构造器创建对象
        try {
            User user = (User) userClass.getDeclaredConstructor().newInstance();  // newInstance()无法传入参数
            System.out.println("user = " + user);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-----------------------------------------------");

        // 3. 通过public的有参构造器创建对象
        // (1) 通过getConstructor()方法获取构造器对象: 此处通过传入的参数类型,去自动匹配User类的构造器,并将其返回
        Constructor<?> constructor = null;
        try {
            constructor = userClass.getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        // (2) 通过构造器对象创建实例
        try {
            Object obj = constructor.newInstance("xiaoRui");
            System.out.println("obj = " + obj);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-----------------------------------------------");

        // 4. 通过非public的有参构造器创建对象
        try {
            // (1) 获取非public的构造器对象
            Constructor<?> declaredConstructor = userClass.getDeclaredConstructor(String.class, int.class);
            // (2) ⚠️暴力访问: 使用反射可以访问private的构造器/方法/属性,反射面前都是纸老虎
            declaredConstructor.setAccessible(true);    // 暴破[暴力破解]
            // (3) 通过构造器对象创建实例
            Object obj = declaredConstructor.newInstance("xiaoR", 27);
            System.out.println("obj = " + obj);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}


class User {
    private String name = "xiaoR";
    private int age = 27;

    public User() {
        System.out.println("无参构造方法");
    }

    public User(String name) {
        this.name = name;
        System.out.println("public, 参数为name的有参构造方法");
    }

    private User(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("private, 参数为name, age的有参构造方法");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}