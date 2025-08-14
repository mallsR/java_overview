package com.xiaor.stage3.reflection_.reflection_theory;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTheory_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        /**
         * 🌟🌟🌟🌟🌟
         * 通过反射,使得程序阔以通过配置文件,调整源码功能
         */
        // 1. 构建Properties对象,读取配置文件的类信息
        Properties properties = new Properties();
        String propertiesPath = "D:\\xiaoR\\file_temp\\java_overview\\src\\main\\java\\com\\xiaor\\stage3\\reflection_\\reflection_theory\\cat.properties";
//        String propertiesPath = ".\\cat.properties";
        properties.load(new FileInputStream(propertiesPath));
        String className = properties.getProperty("name");
        log.info("配置文件中的className: {}", className);
        String methodName = properties.getProperty("method");
        log.info("配置文件中的methodName: {}", methodName);

        // 2. 通过反射,调用配置文件所指定的类的方法
        // (1) 加载类,返回Class类型的对象cls
        Class cls = Class.forName(className);
        // (2) 通过cls得到加载的具体的那个类 com.xiaor.stage3.reflection_.init_use.Cat 的对象实例
        Object obj = cls.newInstance();
        // (3) 通过cls得到加载的具体的那个类 com.xiaor.stage3.reflection_.init_use.Cat 的method的方法对象
        //     即在反射中,可以把方法视为对象
        Method method = cls.getMethod(methodName);
        // (4) 通过method对象,调用方法
        log.info("=============================");
        method.invoke(obj);

        // 3. 原理解析及使用
        // java.lang.reflect.Field;代表类的成员变量,而Filed代表某个具体类的成员变量
        // getField()不能获取私有成员变量
        Field ageField = cls.getField("age");
        log.info("ageField value: {}", ageField.get(obj));

        // java.lang.reflect.Constructor;代表类的构造方法, 而constructor对象代表cls所指向的具体的类的构造器
        Constructor constructor = cls.getConstructor();
        log.info("constructor: {}", constructor);
        // 获取有参构造器
        Constructor constructor2 = cls.getConstructor(String.class);    // 这里传入的String.class就是String类的Class对象
        log.info("constructor2: {}", constructor2);
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
        log.info("小猫叫唤~~");
    }

    public void eat() {
        log.info("小猫吃饭~~");
    }
}