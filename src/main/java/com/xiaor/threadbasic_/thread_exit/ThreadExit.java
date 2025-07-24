package com.xiaor.threadbasic_.thread_exit;

public class ThreadExit {

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 主线程通知cat线程停止
        cat.setStop(true);
    }
}

class Cat extends Thread {
    int times = 0;
    boolean stop = false;
    public void run() {
        while (!stop) {
            System.out.println("线程名: " + Thread.currentThread().getName() +
                    " 线程id: " + Thread.currentThread().getId() + " 第" + (++times) +  "次叫: 喵喵喵");
            // 模拟 Cat 线程睡眠 1 秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
