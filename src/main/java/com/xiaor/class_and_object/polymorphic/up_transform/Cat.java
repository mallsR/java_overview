package com.xiaor.class_and_object.polymorphic.up_transform;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Cat extends Animal{
    @Override
    public void sleep() {
        log.debug("cat sleep");
    }

    public void catchMouse() {
        log.debug("catch mouse");
    }
}
