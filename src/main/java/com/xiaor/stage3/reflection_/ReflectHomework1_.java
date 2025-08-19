package com.xiaor.stage3.reflection_;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xiaoR
 * @version 1.0
 * @date 2025/8/19
 * @description 通过反射创建文件
 */
public class ReflectHomework1_ {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> fileClass = Class.forName("java.io.File");
        // 打印所有的构造器
        Constructor<?>[] declaredConstructors = fileClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("declaredConstructor = " + declaredConstructor);
        }
        System.out.println("==========================================================");

        // 获取指定的构造器
        Constructor<?> constructor = fileClass.getConstructor(String.class);
        System.out.println("选用构造器[" + constructor + "]生成File对象");
        // 创建File对象
        String filePath = "D:\\xiaoR\\file_temp\\java_overview\\src\\main\\java\\com\\xiaor\\stage3\\reflection_\\homework.txt";
        Object o = constructor.newInstance(filePath);
        // 利用File对象,创建文件
        Method createNewFile = fileClass.getDeclaredMethod("createNewFile");
        createNewFile.invoke(o);
        System.out.println("创建文件成功, 文件地址: " + filePath);
    }
}
