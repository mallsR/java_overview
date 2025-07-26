package com.xiaor.stage2.class_and_object.polymorphic.up_transform;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Animal {
    String name = "animal";
    int age = 20;
    public void sleep() {
        log.info("animal is sleep");
    }
}
