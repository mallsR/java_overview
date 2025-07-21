package com.xiaor.class_and_object.inner_class;

/**
 * 演示匿名内部类的使用
 */
public class AnnoymousInnerClass {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.test();
    }
}

class OuterClass {
    public void test() {
        // 使用匿名内部类的方式,可以不用创建这么多类
        //  此处其实就有这样的形式
        /**
         *  class OuterClass$1 implements IA{
         *     @Override
         *     public void cry() {
         *         System.out.println("Tiger 叫唤~~");
         *     }
         *  }
         */
        // jdk在底层创建匿名内部类 OuterClass$1, 立即又创建了 OuterClass$1 的实例
        //      并且把地址返回给tiger
        // 匿名内部类使用一次,就不能使用了.但tiger所指的对象可以多次使用
        IA tiger = new IA() {  // 此时匿名内部类的名称被系统分配为外部类名+"$1"
            public void cry() {
                System.out.println("Tiger 叫唤~~");
            }
        };
        tiger.cry();

        IA dog = new IA() {
            public void cry() {
                System.out.println("Dog 叫唤~~");
            }
        };
        dog.cry();
    }
}

interface IA{
    public void cry();
}