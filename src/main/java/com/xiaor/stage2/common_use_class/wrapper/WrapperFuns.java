package com.xiaor.stage2.common_use_class.wrapper;

public class WrapperFuns {
    public static void main(String[] args) {
        // 包装类(Integer) --> String
        Integer i1 = 100;   // 自动装箱

        String s1 = i1 + "";
        String s2 = i1.toString();
        String s3 = String.valueOf(i1);

        // String --> 包装类(Integer)
        String s4 = "123";
        Integer i2 = Integer.parseInt(s4);  // 使用到自动装箱

    }
}
