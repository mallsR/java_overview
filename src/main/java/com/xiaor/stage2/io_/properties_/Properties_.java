package com.xiaor.stage2.io_.properties_;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Properties_ {
    public static void main(String[] args) {

        // 创建Properties对象
        Properties properties = new Properties();
        // 加载指定配置文件
        String propertiesPath = "D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\mysql.properties";
        try {
            properties.load(new FileInputStream(propertiesPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 将k-v显示到控制台
        properties.list(System.out);

        // 获取key对应的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user: " + user);
        System.out.println("password: " + password);
    }
}
