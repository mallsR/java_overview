package com.xiaor.stage2.class_and_object.codeblock_;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeBlock01 {
    public static void main(String[] args) {
        // 类被加载的三种方式
        // 1, 创建对象实例时
//        BlockParent blockParent = new BlockParent();

        // 2. 创建子类对象实例,父类也会被加载
//        BlockChild blockChild = new BlockChild();

        // 3. 使用类的静态成员时(静态属性,静态方法)
        BlockChild.getAge();
    }
}

@Slf4j
class BlockParent {

    // 静态代码块
    static {
        log.debug("BlockParent 静态代码块被执行...");
    }
}

@Slf4j
class BlockChild extends BlockParent {
    static int age = 20;

    public static int getAge() {
        return age;
    }

    static {
        log.debug("BlockChild 静态代码块被执行...");
    }
}
