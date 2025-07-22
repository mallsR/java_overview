package com.xiaor.collections_.hashset_.map_;

import java.util.HashMap;

public class HashMapSource {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("xiaoR", "20240629");
        map.put("qianqian", "20250702");
        map.put("xiaoR", "20250621");

        System.out.println("map = " + map);

        // HashMap的源码
        /**
         *  1. 执行构造器 HashMap()
         *      初始化加载因子 this.loadFactor = DEFAULT_LOAD_FACTOR; 0.75
         *      HashMap$Node[] table = null;
         *  2. 执行 put()
         *      public V put(K key, V value) {  // K = "xiaoR" V = "20240629"
         *         return putVal(hash(key), key, value, false, true);
         *     }
         *     调用hash方法,计算key的hash值 : (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
         *     调用putVal方法,
         *     final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
         *                    boolean evict) {
         *         Node<K,V>[] tab; Node<K,V> p; int n, i;
         *         // 初次进入, table = null, 调用resize()进行table的初次扩容,
         *         if ((tab = table) == null || (n = tab.length) == 0)
         *             n = (tab = resize()).length;
         *             // 初次进入resize()
         *             // newCap = DEFAULT_INITIAL_CAPACITY;    16
         *             // newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);  12
         *             // 开辟空间,并赋值给table
         *             // Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
         *             // table = newTab;
     *             // 根据key的hash值,计算key在table中的位置,第一次table表各处为null,利用hash, key, value新建节点放入tab[i]
         *         if ((p = tab[i = (n - 1) & hash]) == null)
         *             tab[i] = newNode(hash, key, value, null);
         *         else {
         *         // 第三个节点与第一个节点的hash值一样,所以在table表中处于同一个位置,进行else语句
         *             Node<K,V> e; K k;
         *             // 判断table表当前位置的key是否和新增的key是否为同一个对象,或者内容相同, 则使e指向p
         *             if (p.hash == hash &&
         *                 ((k = p.key) == key || (key != null && key.equals(k))))
         *                 e = p;
     *                 // 如果是一棵红黑树,则按照红黑树的方式进行节点的添加
         *             else if (p instanceof TreeNode)
         *                 e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
         *             else {
         *             // 新增节点的key与table表当前位置的key不同,且当前位置一条链表,则将新增节点与链表中节点逐个进行比对
         *                 for (int binCount = 0; ; ++binCount) {
         *                      // 如果到链表末尾,都没有找到与新增节点的key相同的节点,则将新增节点插入链表末尾(此时e所指为null)
         *                     if ((e = p.next) == null) {
         *                         p.next = newNode(hash, key, value, null);
         *                         // 加入后,判断当前链表的个数,如果超过阈值
         *                         // 则调用treeifyBin进行红黑树的转换工作:
         *                         // 注意,在treeifyBin方法中,会进行条件判断,
         *                         // 如果table的容量小于64,则不进行转换,而直接将table表翻倍,同时重新计算各个hash在table中的位置
         *                         // 如果table表容量达到64,才进行真正的转换
         *                         // 小细节: 在删除节点时,如果节点的个数小于8,则将红黑树又退化为链表
         *                         if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
         *                             treeifyBin(tab, hash);
         *                         break;
         *                     }
         *                     // 在链表中找到与新增节点的key相同的节点, 则退出(此处e所指不为null)
         *                     if (e.hash == hash &&
         *                         ((k = e.key) == key || (key != null && key.equals(k))))
         *                         break;
         *                     p = e;
         *                 }
         *             }
         *             // 如果在链表中找到与新增节点的key相同的节点,则替换value
         *             if (e != null) { // existing mapping for key
         *                 V oldValue = e.value;
         *                 if (!onlyIfAbsent || oldValue == null)
         *                     e.value = value;
         *                 afterNodeAccess(e);
         *                 return oldValue;
         *             }
         *         }
         *         ++modCount;      // 记录修改次数
         *         // 记录hashMap的元素数量,如果大于阈值,则进行扩容
         *         if (++size > threshold)
         *             resize();
     *             // HashMap不做这步操作,用于继承HashMap的结构做功能扩展
         *         afterNodeInsertion(evict);
         *         return null;
         *     }
         */

    }
}
