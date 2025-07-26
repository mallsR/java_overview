package com.xiaor.stage2.class_and_object.abstract_;

import lombok.extern.slf4j.Slf4j;

@Slf4j
abstract class TemplateDetail {
    abstract public void job();     // 抽象方法

    public void calcuateTime() {
        double before = System.currentTimeMillis();
        job();
        double after = System.currentTimeMillis();
        log.debug("程序运行时间: " + (after - before));
    }
}

