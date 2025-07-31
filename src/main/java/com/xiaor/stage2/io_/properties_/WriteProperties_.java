package com.xiaor.stage2.io_.properties_;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteProperties_ {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        /**
         *  Properties类继承自Hashtable类, 底层就是HashTable;
         */
        // 设置properties的键值对
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        properties.setProperty("url", "jdbc:mysql://localhost:3306/test");
        properties.setProperty("driver", "com.mysql.jdbc.驱动");

        // 将k-v键值对存储到文件
        String propertiesPath = "D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\mysql.properties";
        // 创建文件时, 如果指定了 comments, 则会在文件开头添加注释
        properties.store(new FileOutputStream(propertiesPath), null);
        System.out.println("保存配置文件成功...");
    }
}
