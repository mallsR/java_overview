package com.xiaor.common_use_class.stringbuffer_;

public class TestStringBuffer_ {
    public static void main(String[] args) {

        // String --> StringBuffer
        String str1 = "string1";

        // 1. 使用构造器
        // 返回StringBuffer对象,对String没有影响
        StringBuffer sb1 = new StringBuffer(str1);

        // 2. 使用append方法
        StringBuffer sb2 = new StringBuffer();
        sb2.append(str1);


        // StringBuffer --> String
        StringBuffer sb3 = new StringBuffer("xiaoR");

        // 1. 使用toString方法
        String str2 = sb3.toString();

        // 2. 使用构造器
        String str3 = new String(sb3);
    }
}
