package com.xiaor.stage2.threadbasic_.threadsynchronize;

public class ThreadSynchronize {
    public static void main(String[] args) throws InterruptedException{
        /**
         *  由于Saler是实现了Runnable接口的,三个Thread对象saler1,saler2,saler3共享同一个资源,此时在saler的sale方法上加锁
         *  才能保证保证同一时间只有一个Thread访问这个资源
         *
         *  如果Saler是通过继承Thread类的方式,然后实例化三个Saler对象出来,则在saler()方法上加锁,则没有意义.
         *  (因为每个对象都可以抢占一把锁)
         */
        Saler saler = new Saler();
        Thread saler1 = new Thread(saler);
        Thread saler2 = new Thread(saler);
        Thread saler3 = new Thread(saler);

        saler1.start();
        saler2.start();
        saler3.start();
    }
}

class Saler implements Runnable {
    int times = 0;
    private int ticketNum = 100;    // 多个售票员卖票
    boolean stop = false;
    Object obj = new Object();

    /**
     *  可以在静态方法上加锁,这等同于给这个类加锁
     */
    private synchronized static void sale2() {
        /**
         * 也可以使用下述方法给静态方法加锁

        synchronized (Saler.class) {

        }
         */
    }

    private synchronized void sale() {
        /**
         *  如果方法不是静态方法,则默认是给this对象加锁, synchronized(this)
         *  ps: this对象锁是一个非公平锁
         *  也可以在其他对象上,只不过要保证是同一个对象
        synchronized (obj){
            if (ticketNum <= 0) {
                System.out.println("票已卖完...");
                stop = true;
                return;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("线程名: " + Thread.currentThread().getName() +
                    " 线程id: " + Thread.currentThread().getId() + " 卖出一张票, 剩余票数: " + --ticketNum);
        }
         */

        if (ticketNum <= 0) {
            System.out.println("票已卖完...");
            stop = true;
            return;
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程名: " + Thread.currentThread().getName() +
                " 线程id: " + Thread.currentThread().getId() + " 卖出一张票, 剩余票数: " + --ticketNum);
    }

    @Override
    public void run() {
        while (!stop) {
            sale();
        }
    }
}
