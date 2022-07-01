package com.mvp.learn.leetcode.solution.LRUCache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * LRU（least recently used）最近最少使用，淘汰最长时间未被使用的数据。
 */
public class LRUCache {

    /**
     * 最大缓存的数量
     */
    int cap;
    /**
     * 缓存
     */
    Map<String, String> values;
    /**
     * 缓存的key, 按照存入的顺序存储
     */
    Set<String> position;

    public LRUCache(int cap) {
        this.cap = cap;
        values = new HashMap<>(cap);
        position = new LinkedHashSet<>(cap);
    }

    /**
     * 从缓存中获取值，若缓存中没有，则返回null
     */
    public String get(String key) {
        String value = null;
        if (values.containsKey(key)) {
            value = values.get(key);
            position.remove(key);
            position.add(key);
        }

        return value;
    }

    /**
     * 将值放入缓存中
     */
    public void put(String key, String value) {
        if (position.size() == cap) {
            // 若达到缓存上限，则将距现在最久的缓存删除
            String firstKey = position.iterator().next();
            position.remove(firstKey);
            values.remove(firstKey);
        }

        position.add(key);
        values.put(key, value);
    }

    public Map<String, String> getValues() {
        return values;
    }

    public Set<String> getPosition() {
        return position;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.put("a","a");
        lruCache.put("b","b");
        lruCache.put("c","c");
        lruCache.put("d","d");
        System.out.println("position:"+lruCache.getPosition());
        System.out.println("values:"+lruCache.getValues());

        // a将被淘汰
        lruCache.put("e","e");
        System.out.println("position:"+lruCache.getPosition());
        System.out.println("values:"+lruCache.getValues());
    }
}
