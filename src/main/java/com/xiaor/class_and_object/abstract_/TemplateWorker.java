package com.xiaor.class_and_object.abstract_;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateWorker {
    public static void main(String[] args) {
        TemplateDetail aa = new JobA();
        aa.calcuateTime();
        TemplateDetail bb = new JobB();
        bb.calcuateTime();
    }
}
