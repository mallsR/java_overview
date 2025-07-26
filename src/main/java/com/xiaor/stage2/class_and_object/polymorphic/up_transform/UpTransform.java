package com.xiaor.stage2.class_and_object.polymorphic.up_transform;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UpTransform {
    public static void main(String[] args) {
        Animal animal = new Cat();
        // 能访问父类引用中含有的类型
        animal.sleep(); // 输出为"cat sleep", 但实际输出需要看子类类型的方法
    }
}
