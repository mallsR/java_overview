package com.xiaor.stage3.reflection_.analysis_Class_;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

@Slf4j
public class AnalysisClass_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        // 读取cat.properties文件
        Properties properties = new Properties();
        String propertiesPath = "D:\\xiaoR\\file_temp\\java_overview\\src\\main\\java\\com\\xiaor\\stage3\\reflection_\\analysis_Class_\\cat.properties";
        properties.load(new FileInputStream(propertiesPath));

        String className = properties.getProperty("name");
        String methodName = properties.getProperty("method");

        // 通过反射加载Cat类
        // 其会通过ClassLoader的loadClass方法加载 : 但只会加载一次
        /**
         * public Class<?> loadClass(String name) throws ClassNotFoundException {
         *         return loadClass(name, false);
         *     }
         */
        // Class之后的<?>表示不确定的Java类型, 阔以省略
        Class<?> cls = Class.forName(className);

        // 输出cls
        log.info("cls的类型: {}", cls);  // 显示cls对象,是哪个类的Class对象, com.xiaor.stage3.reflection_.analysis_Class_.Cat
        log.info("cls的运行类型: {}", cls.getClass());   // 显示cls对象运行类型, 即Class对象运行类型, java.lang.Class

        // 得到包名
        log.info("包名: {}", cls.getPackage().getName());

        // 得到类名
        log.info("类名: {}", cls.getName());

        // 通过cls创建对象实例
        Object o = cls.getDeclaredConstructor().newInstance();;   // 此处创建的对象其实就是Cat类型的对象
        Cat cat = (Cat) o;     // 可以转换为Cat对象
        log.info("cat: {}",  cat);

        // 获取公有属性, 无法获取私有属性
        Field age = cls.getField("age");
        log.info("age: {}", age.get(cat));

        // 设置公有属性的值
        age.set(cat, 2);

        // 获取所有属性
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            log.info("{}: {}", field.getName(), field.get(cat));
        }
    }
}

@Slf4j
class Cat {
    private String name;
    public int age;
    public Boolean sex;

    public Cat() {
        this.name = "小怪";
        this.age = 1;
        this.sex = true;
    }

    public Cat(String name, int age, Boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void cry() {
        log.info("小猫叫唤~~");
    }

    public void eat() {
        log.info("小猫吃饭~~");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
