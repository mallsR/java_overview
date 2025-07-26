package com.xiaor.stage2.class_and_object.homework.homework3;


interface Calculator {
    public double work(double... nums );
}


public class CellPhone {
    public void testWork(Calculator calc) {
        double res = calc.work(1, 2, 3);
        System.out.println("res: " + res);
    }
}
