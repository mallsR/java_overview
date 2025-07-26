package com.xiaor.stage2.class_and_object.homework.homework1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Frack {
    public static void main(String[] args) {
        int id1 = getNextNum();
        int id2 = getNextNum();
        System.out.println("id1:" + id1 + " id2:" + id2);
    }

    private static int currentNum = 100000;
    private int serialNumber;

    Frack() {
        serialNumber = getNextNum();
    }

    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

//    @Override
//    public String toString() {
//        return serialNumber + "";
//    }
}