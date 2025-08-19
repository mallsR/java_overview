package com.xiaor.stage3.reflection_.load_class_;

/**
 * @author xiaoR
 * @version 1.0
 * @date 2025/8/18
 * @description 演示类加载-初始化阶段
 */
public class LoadClass02_ {
    public static void main(String[] args) {
        /**
         *  1. 加载B类,并生成B类的class对象
         *  2. 连接 num = 0
         *  3. 初始化阶段: 依次自动收集类中的所有静态变量的赋值和静态代码块中的语句, 并合并
         *      收集
         *      clinit() {
         *          System.out.println("B 类静态代码块被执行...");
         *          num = 200;
         *          num = 100;
         *      }
         *      合并
         *      num = 100;
         *  4. B()构造器被执行...
         */
        new B();
        System.out.println("B 类 num: " + B.num);    // 如果直接使用类的静态属性,也会导致类的加载
    }
}

class B {
    static {
        System.out.println("B 类静态代码块被执行...");
        num = 200;
    }
    static int num = 100;

    public B() {
        System.out.println("B 类构造方法被执行...");
    }
}
