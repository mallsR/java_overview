package com.xiaor.stage2.collections_.set_.treeset_;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetSource {
    public static void main(String[] args) {
        /**
         *   1. 当使用无参构造器创建TreeSet时,仍然时无序的
         *   2. 当使用TreeSet(Comparator c)创建TreeSet时,传入一个匿名内部类,按照指定的规则进行排序
         */

        TreeSet treeSet = new TreeSet();
        treeSet.add("xiaoR");
        treeSet.add("qianqian");
        treeSet.add("20240629");
        treeSet.add("20250701");

        System.out.println("treeSet : " + treeSet);

        TreeSet treeSet2 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
//                return ((String) o2).compareTo((String) o1);
//                如果变为比较字符串的长度比较,则相同长度的字符串(即使字符串内容不同),也无法加入.即两个日期均无法加入
                return ((String) o1).length() - ((String) o2).length();
            }
        });

        treeSet2.add("xiaoR");
        treeSet2.add("qianqian");
        treeSet2.add("20240629");
        treeSet2.add("20250701");

        System.out.println("treeSet2 : " + treeSet2);

        /**
         * new TreeSet(new Comparator() {
         *             @Override
         *             public int compare(Object o1, Object o2) {
         *                 return ((String) o2).compareTo((String) o1);
         *             }
         *         });源码解读
         *
         *     1. 构造器把传入的比较器对象,赋给TreeSet的底层TreeMap的成员变量comparator
         *          public TreeMap(Comparator<? super K> comparator) {
         *              this.comparator = comparator;
         *          }
         *     2. 在调用TreeMap的put方法时,会调用TreeMap的compare方法,将传入的key和TreeMap中已有的key进行比较
         *          Comparator<? super K> cpr = comparator;
         *          // cpr是我们的匿名内部类
         *          if (cpr != null) {
         *              do {
         *                  parent = t;
         *                  // 动态绑定到我们的匿名内部类的compare方法
         *                  cmp = cpr.compare(key, t.key);
         *                  if (cmp < 0)
         *                      t = t.left;
         *                  else if (cmp > 0)
         *                      t = t.right;
         *                  else {
         *                      // 如果比较的值相等,这个key就不会再加入
         *                      V oldValue = t.value;
         *                      if (replaceOld || oldValue == null) {
         *                          t.value = value;
         *                      }
         *                      return oldValue;
         *                  }
         *              } while (t != null);
         *          }
         *
         */
    }
}
