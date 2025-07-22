package com.xiaor.collections_.map_.hashtable_;

import java.util.Hashtable;

public class HashTableSource {
    public static void main(String[] args) {
        Hashtable table = new Hashtable();
        table.put("xiaoR", "20240629");
        table.put("qianqian", "20250702");
        table.put("xiaoR", "20250621");

        System.out.println("table = " + table);

        /**
         * Hashtable的源码解析
         *  1. 底层有数组 HashTable$Entry[] 初始化大小为11
         *      Hashtable(int initialCapacity, float loadFactor)
         *
         *      table = new Entry<?,?>[initialCapacity];
         *      threshold = (int)Math.min(initialCapacity * loadFactor, MAX_ARRAY_SIZE + 1);  8
         *  2. 执行 put()
         *      public synchronized V put(K key, V value) {
         *         // Make sure the value is not null
         *         if (value == null) {
         *             throw new NullPointerException();
         *         }
         *
         *         // Makes sure the key is not already in the hashtable.
         *         Entry<?,?> tab[] = table;
         *         int hash = key.hashCode();
         *         int index = (hash & 0x7FFFFFFF) % tab.length;
         *         @SuppressWarnings("unchecked")
         *         Entry<K, V> entry = (Entry<K,V>)tab[index];
         *         // 查找链表中的所有节点,如果当前节点的key与新增节点的key是同一个,或者内容相同, 则将当前节点的value替换为新增节点的value
         *         for(; entry != null ; entry = entry.next) {
         *             if ((entry.hash == hash) && entry.key.equals(key)) {
         *                 V old = entry.value;
         *                 entry.value = value;
         *                 return old;
         *             }
         *         }
         *
         *         addEntry(hash, key, value, index);
         *         return null;
         *     }
         *  3. 调用addEntry()时, 会根据情况进行扩容
         *      private void addEntry(int hash, K key, V value, int index) {
         *         Entry<?,?> tab[] = table;
         *         // 达到阈值,进行k
         *         if (count >= threshold) {
         *             // Rehash the table if the threshold is exceeded
         *             // 调用rehash()计算新的容量,并开辟空间
         *             // int newCapacity = (oldCapacity << 1) + 1;
         *             // Entry<?,?>[] newMap = new Entry<?,?>[newCapacity];
         *             rehash();
         *
         *             tab = table;
         *             hash = key.hashCode();
         *             index = (hash & 0x7FFFFFFF) % tab.length;
         *         }
         *
         *         // Creates the new entry.
         *         @SuppressWarnings("unchecked")
         *         Entry<K, V> e = (Entry<K,V>) tab[index];
         *         tab[index] = new Entry<>(hash, key, value, e);
         *         count++;
         *         modCount++;
         *     }
         */
    }
}
