package com.xiaor.stage3.reflection_.reflection_optimize;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionOptimize_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        /**
         * 🌟🌟🌟🌟🌟
         * 通过反射,使得程序阔以通过配置文件,调整源码功能
         */
        int times = 1000000000;
        test1(times);
        test2(times);
        test3(times);
    }

    public static void test1(int times) {
        Cat cat = new Cat();
        long before_time = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            cat.cry();
        }
        long after_time = System.currentTimeMillis();
        log.info("原始方法循环{}次, 耗时: {}ms", times, after_time - before_time);
    }

    public static void test2(int times) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 1. 构建Properties对象,读取配置文件的类信息
        Properties properties = new Properties();
        String propertiesPath = "D:\\xiaoR\\file_temp\\java_overview\\src\\main\\java\\com\\xiaor\\stage3\\reflection_\\reflection_optimize\\cat.properties";
//        String propertiesPath = ".\\cat.properties";
        properties.load(new FileInputStream(propertiesPath));
        String className = properties.getProperty("name");
//        log.info("配置文件中的className: {}", className);
        String methodName = properties.getProperty("method");
//        log.info("配置文件中的methodName: {}", methodName);

        // 2. 通过反射,调用配置文件所指定的类的方法
        // (1) 加载类,返回Class类型的对象cls
        Class cls = Class.forName(className);
        // (2) 通过cls得到加载的具体的那个类 com.xiaor.stage3.reflection_.init_use.Cat 的对象实例
        Object obj = cls.newInstance();
        // (3) 通过cls得到加载的具体的那个类 com.xiaor.stage3.reflection_.init_use.Cat 的method的方法对象
        //     即在反射中,可以把方法视为对象
        Method method = cls.getMethod(methodName);
        long before_time = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            method.invoke(obj);
        }
        long after_time = System.currentTimeMillis();
        log.info("反射普通方式调用cry循环{}次, 耗时: {}ms", times, after_time - before_time);
    }


    public static void test3(int times) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 1. 构建Properties对象,读取配置文件的类信息
        Properties properties = new Properties();
        String propertiesPath = "D:\\xiaoR\\file_temp\\java_overview\\src\\main\\java\\com\\xiaor\\stage3\\reflection_\\reflection_optimize\\cat.properties";
//        String propertiesPath = ".\\cat.properties";
        properties.load(new FileInputStream(propertiesPath));
        String className = properties.getProperty("name");
//        log.info("配置文件中的className: {}", className);
        String methodName = properties.getProperty("method");
//        log.info("配置文件中的methodName: {}", methodName);

        // 2. 通过反射,调用配置文件所指定的类的方法
        // (1) 加载类,返回Class类型的对象cls
        Class cls = Class.forName(className);
        // (2) 通过cls得到加载的具体的那个类 com.xiaor.stage3.reflection_.init_use.Cat 的对象实例
        Object obj = cls.newInstance();
        // (3) 通过cls得到加载的具体的那个类 com.xiaor.stage3.reflection_.init_use.Cat 的method的方法对象
        //     即在反射中,可以把方法视为对象
        Method method = cls.getMethod(methodName);
        method.setAccessible(true);     // 反射优化,关闭访问权限检查
        long before_time = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            method.invoke(obj);
        }
        long after_time = System.currentTimeMillis();
        log.info("优化反射调用,关闭访问权限检查, 访问cry循环{}次, 耗时: {}ms", times, after_time - before_time);
    }
}



@Slf4j
class Cat {
    private String name;
    public int age;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void cry() {
//        log.info("小猫叫唤~~");
    }

    public void eat() {
        log.info("小猫吃饭~~");
    }
}