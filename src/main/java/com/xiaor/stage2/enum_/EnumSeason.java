package com.xiaor.stage2.enum_;

import lombok.extern.slf4j.Slf4j;

@Slf4j
enum EnumSeason {
    // 1. 使用enum来实现枚举,要求将定义常量对象,写在最前面, 多个常量,逗号间隔
    // 2. SPRING("春天", "温暖")其实等价于 public static final EnumSeason SPRING = new EnumSeason("春天", "温暖");
    SPRING("春天", "温暖"), SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"), WINTER("冬天", "寒冷");
    private String name;
    private String desc;

    // 构造方法私有化,不允许创造其他类型的常量
    private EnumSeason(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    // 可以提供get方法,但不能提供set方法
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        String res = "EnumSeason{name=" + name + ", desc=" + desc + "}";
//        System.out.println(res);
        return res;
    }
}
