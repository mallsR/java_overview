package com.xiaor.stage2.common_use_class.date_operate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

    public static void main(String[] args) {
        Date date = new Date();  // 默认获取当前时间
        System.out.println(date);

        // 转化为特定格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));
    }
}
