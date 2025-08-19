package com.xiaor.stage3.reflection_.load_class_;

/**
 *
 */
public class LoadClass {
    public static void main(String[] args) {

    }
}

class Cat {
    /**
     * 连接阶段-准备工作,属性是如何处理的
     * 1. age 是实例属性,不是静态变量,因此在准备阶段,不会分配内存
     * 2. age2 是静态变量,因此会在准备阶段分配内存,但默认设置为0, 而不是20
     * 3. age2 是static final 常量,它和静态变量不一样,因为一旦赋值就不能改变,因此在准备阶段就分配内存,并赋值为30
     */
    public int age = 10;
    public static int age2 = 20;
    public static final int age3 = 30;
//    public Cat()
}
