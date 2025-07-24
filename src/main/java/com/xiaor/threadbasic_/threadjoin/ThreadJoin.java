package com.xiaor.threadbasic_.threadjoin;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new Cat());

        for (int i = 0; i < 10; i++) {
            System.out.println("主线程名: " + Thread.currentThread().getName() +
                    " 线程id: " + Thread.currentThread().getId() + " 第" + (i + 1) +  "执行...");
            if (i == 5) {
                thread.start();     // 让子线程开始执行
                try {
                    thread.join();  // 主线程暂停,把cpu资源让给子线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Thread.sleep(1000);
        }
    }
}

class Cat implements Runnable {
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
            if (times == 10) {
                stop = true;
            }
        }
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
