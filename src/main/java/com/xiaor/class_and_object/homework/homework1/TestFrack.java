package com.xiaor.class_and_object.homework.homework1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestFrack {
    public static void main(String[] args) {
        Frack frack1 = new Frack();
        Frack frack2 = new Frack();
        Frack frack3 = new Frack();
        System.out.println(frack1.getSerialNumber());
        System.out.println(frack2.getSerialNumber());
        System.out.println(frack3.getSerialNumber());
    }
}
