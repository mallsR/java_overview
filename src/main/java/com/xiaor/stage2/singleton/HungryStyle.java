//package com.xiaor.singleton;
//
//public class HungryStyle {
//    public static void main(String[] args) {
//        GirlFriend girlFriend = GirlFriend.getInstance();
//        System.out.println(girlFriend);
//        GirlFriend girlFriend2 = GirlFriend.getInstance();
//        System.out.println(girlFriend2);
//    }
//}
//
//class GirlFriend {
//    private String name;
//    // 2,创建对象,注意使用static
//    // note: 类加载时,就自动创建对象,即使不被使用,也会创建所以称为饿汉式
//    private static GirlFriend girlFriend = new GirlFriend("qianqian");
//
//    private GirlFriend(String name){
//        this.name = name;
//    };     // 1,构造器私有化
//
//    // 如果这个方法不是静态,则必须创建一个girlFriend才能调用,不符合需求
//    public static GirlFriend getInstance(){     //3, 向外暴露静态的公共方法
//        return girlFriend;
//    }
//
//    @Override
//    public String toString() {
//        return "GirlFriend{" +
//                "name='" + name + '\'' +
//                '}';
//    }
//}
