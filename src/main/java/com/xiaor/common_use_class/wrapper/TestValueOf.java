package com.xiaor.common_use_class.wrapper;

public class TestValueOf {
    public static void main(String[] args) {
        Object obj = true ? Integer.valueOf(1) : Double.valueOf(2);
        System.out.println(obj);

        Object obj2;
        if (true) {
            obj2 = Integer.valueOf(1);
        } else {
            obj2 = Double.valueOf(2);
        }
        System.out.println(obj2);
    }
}

// 答案
// 1.0
// 1
