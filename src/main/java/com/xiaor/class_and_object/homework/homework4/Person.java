package com.xiaor.class_and_object.homework.homework4;

public class Person {
    private String name;
    private Vehicles vehicles;

    Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    // 一般情况下骑马,遇到大河就坐船
    // 这里涉及到一个编程思想,可以把具体的要求,封装成方法-->编程思想
    // 思考一个问题,如何不浪费,在构建对象时,传入的交通工具对象->动脑筋, 使用多态性 + instanceof进行判断
    public void commom() {
        if( ! (vehicles instanceof Horse) ) {
            vehicles = VehicleFactory.getHorse();
        }
        vehicles.work();
    }

    public void passRiver() {
        if ( ! (vehicles instanceof Boat) ) {
            vehicles = VehicleFactory.getBoat();
        }
        vehicles.work();
    }

    public void passMountain() {
        if ( ! (vehicles instanceof Plane) ) {
            vehicles = VehicleFactory.getPlane();
        }
        vehicles.work();
    }
}
