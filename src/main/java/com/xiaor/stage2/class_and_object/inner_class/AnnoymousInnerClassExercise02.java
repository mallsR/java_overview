package com.xiaor.stage2.class_and_object.inner_class;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnnoymousInnerClassExercise02 {
    public static void main(String[] args) {

        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小懒龙起床啦~~");
            }
        });

        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("bb起床啦~~");
            }
        });

        log.info("通过向函数传递匿名内部类,可以实现在不同的闹钟响应不同的消息...");
    }
}

class CellPhone{
    void alarmClock(Bell bell){
        bell.ring();
    }
}

interface Bell{
    public void ring();
}
