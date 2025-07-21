package com.xiaor.class_and_object.inner_class;

public class MemberInnerClass {
    public static void main(String[] args) {
        MemberOuter memberOuter = new MemberOuter();
        memberOuter.test();

        // 外部其他类 使用成员内部类的三种方式
        // 1. 把new MemberInner()看作是memberOuter的成员
        MemberOuter.MemberInner memberInner = memberOuter.new MemberInner();
        memberInner.say();

        // 2. 在外部类中写一个方法返回MemberInner的对象
        MemberOuter.MemberInner memberInner1 = memberOuter.getMemberInner();
        memberInner1.say();
    }
}

class MemberOuter {
    private int age = 25;
    private String name = "qianqian";
    // 成员内部类的定义位置在外部类的成员位置
    // 可以使用访问修饰符public, private, protected
    class MemberInner {
        private double height = 168;
        private int age = 18;
        public void say() {
            // 如果属性和外部类属性重名,遵从就近原则.
            // 想访问外部类的成员时,需要通过 外部类名.this.成员名 进行访问
            System.out.println("my age = " + age + ", name = " + name + " my inner age = " + MemberOuter.this.age);
        }
    }

    public MemberInner getMemberInner() {
        return new MemberInner();
    }

    public void test() {
        MemberInner inner = new MemberInner();
        inner.say();
        // 外部类的方法中,可以直接访问成员内部类的私有属性
        System.out.println("height = " + inner.height);
    }
}