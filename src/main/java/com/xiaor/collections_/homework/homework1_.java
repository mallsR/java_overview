package com.xiaor.collections_.homework;

import com.xiaor.class_and_object.homework.homework4.Person;
import com.xiaor.class_and_object.homework.homework4.Vehicles;

import java.util.TreeSet;

public class homework1_ {
    public static void main(String[] args) {
        /**
         *  此处情况下,会报一个异常ClassCastException
         *  因为TreeSet()构造器没有传入基于Comparable接口的匿名内部类,
         *  所以在添加元素时,在底层会调用Comparable<? super K> k = (Comparable<? super K>) key;
         *  即尝试把Person转换为Comparable类型,但是Person类没有实现Comparable接口,所以会抛出异常
         */

        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person("xiaoR", new Vehicles() {
            @Override
            public void work() {
                System.out.println("普通情况下,骑马前行...");
            }
        }));
    }
}

