package com.xiaor.common_use_class.date_operate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestLocalDateTime {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(now.format(formatter));
    }
}
