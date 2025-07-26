package com.xiaor.stage2.collections_;

import java.util.ArrayList;
import java.util.Arrays;
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


        // 查找,替换
        // max: 返回List中最大的元素
        System.out.println("max : " + Collections.max(list));

        // max(Collection, Comparator): 自定义比较器
        System.out.println("max : " + Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        }));

        // min: 跟max类似

        // frequency: 返回指定元素在集合中出现的次数
        System.out.println("xiaoR出现的次数 : " + Collections.frequency(list, "xiaoR"));

        // copy: 将集合中的元素复制到数组中(保证目标集合元素空间不小于源集合)
//        ArrayList desc = new ArrayList(list.size());  // 为何在初始化时无法分配指定大小的内存
        ArrayList desc = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            desc.add(i);
        }
        System.out.println("desc.size(): " + desc.size());
        System.out.println("list.size(): " + list.size());
        Collections.copy(desc, list);
        System.out.println("copy后的desc : " + desc);

        // boolean replaceAll(List list, Object oldVal, Object newVal): 替换集合中所有元素为newVal
        Collections.replaceAll(list, "xiaoR", "小R");
        System.out.println("replaceAll后的list : " + list);
    }
}
