package com.xiaor.class_and_object.inner_class;

public class AnnoymousInnerClassExercise {

    public static void main(String[] args) {
        // 使用匿名内部类可以很方便地为函数传入一个匿名内部类对象作为参数
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("这是一副名画...");
            }
        });
    }

    public static void f1(IL il) {
        il.show();
    }
}

interface IL{
    public void show();
}