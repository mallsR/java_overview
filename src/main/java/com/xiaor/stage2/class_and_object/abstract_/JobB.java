package com.xiaor.stage2.class_and_object.abstract_;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JobB extends TemplateDetail{
    public void job() {
        double sum = 1.0;
        for (int i = 1; i <= 100; i++) {
            sum *= i;
        }
        System.out.println("1 * 2 * ... * 100 = " + sum);
    }
}
