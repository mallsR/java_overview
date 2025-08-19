package com.xiaor.stage3.reflection_.access_private_;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xiaoR
 * @version 1.0
 * @date 2025/8/19
 * @description 演示通过反射的暴破方式获取private/protected属性
 */
public class ReflectAccessProperty_ {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1. 创建Student的Class对象
        Class<?> studentClass = Class.forName("com.xiaor.stage3.reflection_.access_private_.Student");
        // 2. 创建Student对象
        Student student = (Student) studentClass.getDeclaredConstructor().newInstance();
        System.out.printf("student: %s\n", student);
        System.out.println("===============================================");

        // 3. 获取public属性name的Field对象
        try {
            Field name = studentClass.getField("name");
            name.set(student, "xiaoR");
            System.out.println(name.getName() + ": " + name.get(student));
            System.out.printf("student: %s\n", student);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        System.out.println("===============================================");

        // 4. 获取private属性age的Field对象
        try {
            Field age = studentClass.getDeclaredField("age");
            age.setAccessible(true);    // 暴破
            age.set(student, 27);
            System.out.println(age.getName() + ": " + age.get(student));
            System.out.println(String.format("student: %s\n", student));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}

class Student {
    public String name;
    private int age;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
