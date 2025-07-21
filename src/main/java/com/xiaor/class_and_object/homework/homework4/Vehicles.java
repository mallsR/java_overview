package com.xiaor.class_and_object.homework.homework4;

interface Vehicles {
    public void work();
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("一般情况下,骑马前行...");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("遇到大河,坐船前行...");
    }
}

class Plane implements Vehicles {
    @Override
    public void work() {
        System.out.println("遇到火焰山,乘飞机前行...");
    }
}

class VehicleFactory {
    // 保证马始终是同一匹马
    public static Horse horse = new Horse();    // 饿汉式

    private VehicleFactory() {}     // 构造器私有化, 防止创建工厂对象

    // 定义为静态方法,在类加载时就加载了静态方法,不用创建工厂类对象
    public static Horse getHorse() {
//        return new Horse();
        return horse;
    }

    public static Boat getBoat() {
        return new Boat();
    }

    public static Plane getPlane() {
        return new Plane();
    }
}