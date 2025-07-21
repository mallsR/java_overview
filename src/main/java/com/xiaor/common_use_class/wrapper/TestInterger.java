package com.xiaor.common_use_class.wrapper;

public class TestInterger {
    public static void main(String[] args) {
        // jdk5.0之前需要手动装箱和拆箱
        int n1 = 100;
        Integer integer1 = Integer.valueOf(n1);
        int n2 = integer1.intValue();
        // jdk5.0之后自动装箱和拆箱
        Integer integer2 = n1;  // 底层还是调用的Integer.valueOf()方法
        int n3 = integer2;      // 底层还是调用的integer2.intValue()方法
    }
}
