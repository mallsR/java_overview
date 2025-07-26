package com.xiaor.stage2.class_and_object.homework.homework5;

public class Car {
    private double temperature;

    // 成员内部类
    class Air {
        public void flow() {
            if (temperature > 40) {
                System.out.println("空调吹冷风...");
            } else if (temperature < 0) {
                System.out.println("空调吹暖风...");
            } else {
                System.out.println("关闭空调...");
            }
        }
    }

    Car(double temperature) {
        this.temperature = temperature;
    }

    public Air getAir() {
        return new Air();
    }
}
