package com.xiaor.stage2.class_and_object.inner_class;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.fun1();
        log.debug("outer02 hashcode : {}", outer02);
    }
}

@Slf4j
class Outer02 {
    private int n2 = 10;
    public void outerFun() {
        log.debug("outerFun...");
    }
    public void fun1() {
        // 1. 局部内部类定义在外部类的局部位置,通常在方法中
        // 3. 不能添加访问修饰符,但是阔以添加final修饰
        // 4. 作用域: 仅仅在定义它的方法或代码块中
        final class Inner02 {  // 局部内部类(本质仍然是一个类: 只是定义在外部类的局部,具有特定的生存空间及访问权限)
            // 7. 如果外部类与局部内部类的成员重名,遵循就近原则,如果想访问外部类的成员,需要使用 外部类名.this.成员名 去访问
            private int n2 = 20;
            public void innerFun1() {
                // 5. 可以直接访问外部类的成员, 包括私有的
                log.debug("n2 = " + n2 + " 外部类的n2=" + Outer02.this.n2);
                outerFun();
                log.debug("Outer02.this hashcode : {}", Outer02.this);
            }
        }

        // 6. 外部类通过创建内部类的对象,然后访问其方法
        Inner02 inner02 = new Inner02();
        inner02.innerFun1();
    }
}
