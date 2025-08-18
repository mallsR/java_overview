package com.xiaor.stage3.reflection_.get_class_;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 编译阶段,通过forName获取类的Class对象
        String classPath = "com.xiaor.stage3.reflection_.get_class_.Cat";
        Class<?> cls1 = Class.forName(classPath);
        log.info("cls1: {}", cls1);

        // 2. 运行阶段,通过类名.class获取Class对象,  应用场景: 参数传递
        Class<?> cls2 = Cat.class;
        log.info("cls2: {}", cls2);

        // 3. 通过对象.getClass()获取Class对象,  应用场景: 有对象实例
        Cat cat = new Cat();
        Class<?> cls3 = cat.getClass();
        log.info("cls3: {}", cls3);

        // 4. 通过类加载器[4种]来获取到类的Class对象
        // (1) 先得到类加载器 cat
        ClassLoader classLoader = cat.getClass().getClassLoader();
        // (2) 通过类加载器获取类
        Class<?> cls4 = classLoader.loadClass(classPath);
        log.info("cls4: {}", cls4);

        // 5. 基本数据类型,阔以通过如下方式得到Class类对象
        Class<Integer> integerClass = int.class;
        Class<Boolean> booleanClass = boolean.class;
        Class<Character> characterClass = char.class;
        log.info("integerClass: {}", integerClass);     // 此处在打印日志时,自动将得到的Class对象转为基本类型

        // 6. 基本数据类型的包装类, 可以通过如下方式得到Class类对象
        Class<Integer> integerClass1 = Integer.TYPE;
        Class<Boolean> booleanClass1 = Boolean.TYPE;
        Class<Character> characterClass1 = Character.TYPE;
        log.info("integerClass1: {}", integerClass1);

        // 但intergerClass和intergerClass1指向同一个类
        log.info("integerClass : {}", integerClass.hashCode());
        log.info("integerClass1 : {}", integerClass1.hashCode());

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
