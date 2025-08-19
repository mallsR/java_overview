package com.xiaor.stage3.reflection_.access_private_;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xiaoR
 * @version 1.0
 * @date 2025/8/19
 * @description 演示通过反射暴破访问非public方法
 */
public class ReflectAccessMethod_ {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1. 通过反射获取的Employee的Class对象
        Class<?> employeeClass = Class.forName("com.xiaor.stage3.reflection_.access_private_.Employee");
        System.out.println("=======================================");
        // 2. 创建Employee对象
        Constructor<?> constructor = employeeClass.getConstructor();
        Employee employee = (Employee) constructor.newInstance();
        // 3. 获取Employee类中的public方法
        Method work = employeeClass.getMethod("work", float.class);
        // 反射调用的方法默认的返回值是Object类型,但实际的运行类型,还是跟方法的返回值类型一致
        Object fruit = work.invoke(employee, 2200f);
        System.out.printf("劳动收获: %s\n",  fruit);
        System.out.println("=======================================");
        // 4. 获取Employee类中的private方法
        Method say = employeeClass.getDeclaredMethod("say");
        say.setAccessible(true);    // 暴破
        Object msg = say.invoke(employee);
        System.out.printf("偷偷说的话: %s\n",  msg);
    }
}

class Employee {
    public String name;
    private int age;

    public Employee() {
        System.out.println("Emplyee的无参构造方法~~");
    }

    public float work(float baseSalary) {
        return 18000.0f;
    }

    private String say() {
        return "骂骂咧咧~~";
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
