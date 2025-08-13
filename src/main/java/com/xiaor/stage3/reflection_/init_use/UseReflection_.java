package com.xiaor.stage3.reflection_.init_use;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.lang.reflect.Method;

@Slf4j
public class UseReflection_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        /**
         * 🌟🌟🌟🌟🌟
         * 通过反射,使得程序阔以通过配置文件,调整源码功能
         */
        // 1. 构建Properties对象,读取配置文件的类信息
        Properties properties = new Properties();
        String propertiesPath = "D:\\xiaoR\\file_temp\\java_overview\\src\\main\\java\\com\\xiaor\\stage3\\reflection_\\init_use\\cat.properties";
//        String propertiesPath = ".\\cat.properties";
        properties.load(new FileInputStream(propertiesPath));
        String className = properties.getProperty("name");
        log.info("配置文件中的className: {}", className);
        String methodName = properties.getProperty("method");
        log.info("配置文件中的methodName: {}", methodName);

        // 2. 通过反射,调用配置文件所指定的类的方法
        // (1) 加载类,返回Class类型的对象cls
        Class cls = Class.forName(className);
        // (2) 通过cls得到加载的类 com.xiaor.stage3.reflection_.init_use.Cat 的对象实例
        Object obj = cls.newInstance();
        // (3) 通过cls得到加载的类 com.xiaor.stage3.reflection_.init_use.Cat 的method的方法对象
        //     即在反射中,可以把方法视为对象
        Method method = cls.getMethod(methodName);
        // (4) 通过method对象,调用方法
        log.info("=============================");
        method.invoke(obj);
    }
}


@Slf4j
class Cat {
    private String name;
    public void cry() {
        log.info("小猫叫唤~~");
    }

    public void eat() {
        log.info("小猫吃饭~~");
    }
}