package com.xiaor.threadbasic_.thread_create;

public class UseThread {

    public static void main(String[] args) {
        Cat cat = new Cat();
//        cat.run();  // 这样并不会新开线程,而相当于main线程去执行cat的run方法
        /**
         * start0()是本地方法,是JVM调用, 底层借助C/C++实现
         * 真正实现多线程的效果,其实是start0(),start()方法->start0()方法->run()方法
         * private native void start0();
         */

        cat.start();    // 启动线程->最终执行Cat的run方法

        // 主线程不会阻塞,会继续执行
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程名:" + Thread.currentThread().getName() +
                    " 主线程id:" + Thread.currentThread().getId() + " 主线程第" + (i + 1) + "次执行...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


/**
 *  1. 一个类继承了Thread类,那么这个类就可以当做一个线程使用
 *  2. 我们会重写run方法,写上自己的业务逻辑
 *  3. run Thread类 实现了Runnable接口的run方法
 */
class Cat extends Thread {
    int times = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("线程名:" + Thread.currentThread().getName() +
                    " 线程id:" + Thread.currentThread().getId() + " 第" + (++times) + "次猫叫: 喵喵喵...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (times == 10) {
                break;
            }
        }
    }
}
