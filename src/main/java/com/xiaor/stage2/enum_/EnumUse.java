package com.xiaor.stage2.enum_;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnumUse {
    public static void main(String[] args) {
        EnumSeason summer = EnumSeason.SUMMER;
        // name()    用于获取枚举对象的名称
        System.out.println(summer.name());
        // ordinal() 输出该枚举对象的次序, 从0开始编号
        System.out.println(summer.ordinal());
        // values(): 从反编译可以看出 values 方法,返回EnumSeason[]
        // 含有定义的所有枚举对象
        EnumSeason[] values = summer.values();
        for (EnumSeason value : values) {
            System.out.println(value);
        }

        // valueOf:  将字符串转化为枚举对象,要求字符串必须为已有的常量名,否则报异常
        EnumSeason autumn = EnumSeason.valueOf("AUTUMN");
        System.out.println("autumn: " + autumn);
        System.out.println(summer == autumn);

        // compareTo: 比较两个枚举常量,比较的就是编号
        System.out.println(summer.compareTo(autumn));

        // toString: 默认返回当前对象名,子类可以重写该方法,用于返回对象的属性信息
        System.out.println(summer.toString());
    }
}
