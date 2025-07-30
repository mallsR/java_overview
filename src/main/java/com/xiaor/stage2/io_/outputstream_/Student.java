package com.xiaor.stage2.io_.outputstream_;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    // 添加这个字段，可以提高版本兼容性,用于解决序列化版本不一致问题
    private static final long serialVersionUID = 1L;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

