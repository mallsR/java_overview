package com.xiaor.stage2.class_and_object.interface_;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Phone implements UsbInterface{
    @Override
    public void start() {
        log.debug("手机开始工作...");
    }

    @Override
    public void stop() {
        log.debug("手机停止工作...");
    }
}
