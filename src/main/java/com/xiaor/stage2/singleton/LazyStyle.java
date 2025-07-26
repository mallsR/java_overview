package com.xiaor.stage2.singleton;


public class LazyStyle {
    public static void main(String[] args) {
        GirlFriend girlFriend = GirlFriend.getInstance();
        System.out.println(girlFriend);
        GirlFriend girlFriend2 = GirlFriend.getInstance();
        System.out.println(girlFriend2);
    }
}

class GirlFriend {
    private String name;
    // 2,定义静态属性成员,注意使用static
    private static GirlFriend girlFriend;

    private GirlFriend(String name){
        this.name = name;
        System.out.println("GirlFriend()");
    };     // 1,构造器私有化

    // 如果这个方法不是静态,则必须创建一个girlFriend才能调用,不符合需求
    public static GirlFriend getInstance(){     //3, 向外暴露静态的公共方法
        // 存在线程安全问题: 如果多个线程同时进入下面的语句
        if (girlFriend == null){     // 如果还没有对象
            girlFriend = new GirlFriend("qianqian");
        }
        return girlFriend;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}

