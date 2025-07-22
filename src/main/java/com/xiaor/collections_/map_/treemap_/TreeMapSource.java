package com.xiaor.collections_.map_.treemap_;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapSource {
    public static void main(String[] args) {
        /**
         * 1. 使用默认的构造器,创建TreeMap对象,还是无序的
         * 2. 使用TreeMap(Comparator c)创建TreeMap对象,按照指定的规则进行排序
         */
        TreeMap treeMap = new TreeMap();
        treeMap.put("xiaoR", "20240629");
        treeMap.put("qianqian", "20250701");
        treeMap.put("20240629", "xiaoR");
        treeMap.put("20250701", "qianqian");

        System.out.println("treeMap = " + treeMap);

        TreeMap treeMap2 = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o2).compareTo((String) o1);
            }
        });
        treeMap2.put("xiaoR", "20240629");
        treeMap2.put("qianqian", "20250701");
        treeMap2.put("20240629", "xiaoR");
        treeMap2.put("20250701", "qianqian");

        System.out.println("treeMap2 = " + treeMap2);

        /**
         *  带匿名内部类的构造器的源码解读
         *  1. 创建TreeMap对象
         *      public TreeMap(Comparator<? super K> comparator) {
         *         this.comparator = comparator;
         *     }
         *  2. 初次添加元素:
         *      // 第一次添加元素时的compare, 没有接收比较结果,主要用于检测key是否为 null
         *      compare(key, key); // type (and possibly null) check
         *      root = new Entry<>(key, value, null);
         *         size = 1;
         *         modCount++;
         *  3. 以后添加元素
         *      Comparator<? super K> cpr = comparator;
         *         if (cpr != null) {
         *             // 为key在树中找到合适的位置,并将其放入
         *             do {
         *                 parent = t;
         *                 cmp = cpr.compare(key, t.key);
         *                 if (cmp < 0)
         *                     t = t.left;
         *                 else if (cmp > 0)
         *                     t = t.right;
         *                 else {
         *                     // 如果遍历过程中,发现准备添加的key和当前已有的key相等,就不添加
         *                     V oldValue = t.value;
         *                     if (replaceOld || oldValue == null) {
         *                         t.value = value;
         *                     }
         *                     return oldValue;
         *                 }
         *             } while (t != null);
         *         }
         */
    }
}
