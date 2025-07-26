package com.xiaor.stage2.collections_.map_.hashmap_;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMap {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("xiaoR", "20240629");
        map.put("qianqian", "20250702");


        // 1. k-v最后是HashMap$Node node = newNode(hash, key, value, null);
        // 2. 为了程序员遍历方便,map内部会创建一个EntrySet集合, EntrySet集合中存放的元素是Entry对象,
        // 而Entry对象中保存的元素是k-v, 也就是EntrySet<Entry<k, v>> 即: transient Set<Map.Entry<K,V>> entrySet;
        // 3. 在entrySet集合中, 定义的类型是Map.Entry<K,V>, 但实际上存放的还是HashMap$Node对象
        //    这是因为static class Node<K, V> implements Map.Entry<K,V>
        // 4. 当把HashMap$Node对象存放到entrySet就方便我们的遍历,因为Map.Entry提供了重要方法
        //    K getKey(); V getValue();
        Set set = map.entrySet();
        System.out.println(set.getClass());
        for (Object obj : set) {
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
