package com.xiaor.generic;

import java.util.ArrayList;

public class TestGeneric {
    public static void main(String[] args) {
        /**
         * ArrayList构造器支持泛型,其原本保存Object对象
         * 下方尖括号中的Dog,指明了ArrayList保存的元素类型为Dog,编译器在编译阶段就会对ArrayList保存的元素类型进行检查
         */
        ArrayList<Dog> list = new ArrayList<Dog>();

        /**
         * 运行时,可以直接使用增强For循环,指定取出Dog类型的对象,而不用像之前一样取出Object对象,再进行向下转型,提高效率
         */
        for (Dog dog : list) {
            dog.show();
        }
    }
}

class Dog{
    private String name;

    public void show()
    {
        System.out.println("Dog");
    }
}
