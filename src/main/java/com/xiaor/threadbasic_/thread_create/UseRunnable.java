package com.xiaor.threadbasic_.thread_create;

public class UseRunnable {
    public static void main(String[] args) {
        Dog dog = new Dog();
//        dog.start();        // 从Runnable接口实现的类没有start方法，只能用Thread类中的start方法启动
        /**
         *  为什么能借助thread的start方法,启动线程
         *  是因为Thread类使用了代理模式:
         *      1. Thread类内部有一个Runnable接口的属性
         *      2. 而Dog类实现了Runnable接口
         *      3. Thread对象能接收Dog类型的对象
         *      4. Thread类内部有一个start方法,该方法会调用start0方法,进而调用Dog对象的run()方法
         */
        Thread thread = new Thread(dog);
        thread.start();
    }
}


class Dog implements Runnable {
    int times = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("线程名: " + Thread.currentThread().getName() +
                    " 线程id: " + Thread.currentThread().getId() + " 第" + (++times) + "次执行: 汪汪汪...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}