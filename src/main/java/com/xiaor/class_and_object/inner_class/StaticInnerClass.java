package com.xiaor.class_and_object.inner_class;

public class StaticInnerClass {
    public static void main(String[] args) {
        // 外部其他类 访问 惊天内部类
        // 1. 可以通过  外部类名.静态内部类名()创建对象
        StaticOuter.StaticInner staticInner = new StaticOuter.StaticInner();
        staticInner.say();
        // 2. 编写一个方法(静态方法或非静态方法都行, 静态方法效率更快),可以返回静态内部类的对象实例
        StaticOuter.StaticInner staticInner1 = new StaticOuter().getStaticInner();
        staticInner1.say();
    }
}

class StaticOuter {
    static private int age = 25;
    static private String name = "qianqian";

    // 本质上等于 成员内部类 + static
    // 1. 只能访问外部类的静态成员,不能访问外部类的非静态成员
    // 5. 作用域: 同其他成员,为整个类体
    // 7. 注意: 如果静态内部类的成员与外部类成员重名,遵循就近原则,如果想访问外部类的成员,可以使用(外部类名.成员)去访问
    static class StaticInner {
        private int age = 18;
        public void say() {
            System.out.println("my name is " + name);
            System.out.println("my inner age is " + age + ", my outer age is " + StaticOuter.age);
        }
    }

    public StaticInner getStaticInner() {
        return new StaticInner();
    }
}
