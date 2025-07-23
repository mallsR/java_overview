package com.xiaor.collections_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestCollections {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add("xiaoR");
        list.add("qianqian");
        list.add("20240629");
        list.add("20250702");

        System.out.println("list : " + list);

        // reverse: 反转List中元素顺序
        Collections.reverse(list);
        System.out.println("反转后的list : " + list);

        // shuffle: 随机排序List中的元素
        Collections.shuffle(list);
        System.out.println("随机排序后的list : " + list);

        // sort: 排序List中的元素, 默认升序
        Collections.sort(list);
        System.out.println("默认排序后的list : " + list);

        // sort(List list, Comparator c): 自定义排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // 按照字符串的长度升序排序
                // 也阔以加入一些校验代码
                return ((String)o2).length() - ((String)o1).length();
            }
        });
        System.out.println("自定义排序后的list : " + list);

        // swap: 交换List中指定位置的元素
        Collections.swap(list, 0, 1);
        System.out.println("交换后的list : " + list);
    }
}
