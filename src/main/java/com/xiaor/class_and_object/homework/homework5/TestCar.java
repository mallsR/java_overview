package com.xiaor.class_and_object.homework.homework5;

public class TestCar {
    public static void main(String[] args) {
        Car car1 = new Car(60);
        car1.getAir().flow();
        Car car2 = new Car(-10);
        car2.getAir().flow();
        Car car3 = new Car(20);
        car3.getAir().flow();
    }
}
