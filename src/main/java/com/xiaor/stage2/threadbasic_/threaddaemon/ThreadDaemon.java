package com.xiaor.stage2.threadbasic_.threaddaemon;

public class ThreadDaemon {
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new Cat());
        thread.setDaemon(true);     // 将子线程设置为守护线程,当主线程结束时,子线程自动退出
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("主线程名: " + Thread.currentThread().getName() +
                    " 线程id: " + Thread.currentThread().getId() + " 第" + (i + 1) +  "执行...");
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
//            if (times == 10) {
//                stop = true;
//            }
        }
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
