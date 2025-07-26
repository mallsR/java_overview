package com.xiaor.stage2.class_and_object.final_;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FinalAttribute {
    public static void main(String[] args) {
        // 如果只使用static修饰属性,在使用静态属性时,会导致类的加载
        // final和static配合使用,不会导致类的加载
        System.out.println("FinalStaticAttribute TAX_RATE : " + FinalStaticAttribute.TAX_RATE);
    }
}

class Attribute {
    /**
     * final修饰的属性,赋予初始值的三种方式
     */
    public final double TAX_RATE = 0.8;
    public final double TAX_RATE2;
    public final double TAX_RATE3;

    Attribute() {
        TAX_RATE2 = 0.7;
    }

    {
        TAX_RATE3 = 0.8;
    }
}

class StaticAttribute {
    /**
     * 静态final属性的赋值有两种方式
     * 1. 在定义时
     * 2. 在静态代码块中
     */
    public static final double TAX_RATE = 0.8;
    public static final double TAX_RATE2;

    static {
        TAX_RATE2 = 0.7;
    };
}

@Slf4j
class FinalStaticAttribute {
    public final static double TAX_RATE = 0.8;

    static {
        log.debug("类被加载...");
    }
}