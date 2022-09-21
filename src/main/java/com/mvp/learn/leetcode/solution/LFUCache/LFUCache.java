package com.mvp.learn.leetcode.solution.LFUCache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * LFU(Least Frequently Used)最不经常使用置换算法，淘汰一定时期内被访问次数最少的元素。如果元素的一定时间内的访问次数相同时，则比较他们的最新一次的访问时间。
 * 注意：put操作、get操作都增加访问次数。
 * @param <k>
 * @param <v>
 */
public class LFUCache<k, v> {
    /**
     * 最大缓存的数量
     */
    private final int capacity;

    /**
     * 缓存
     */
    private Map<k, v> cache = new HashMap<>();

    /**
     * 缓存访问状态信息
     */
    private Map<k, HitRate> count = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 新增key与value的对应关系。
     *
     * @param key   key值
     * @param value value值
     */
    public void put(k key, v value) {
        v v = cache.get(key);
        if (v == null) {
            if (cache.size() == capacity) {
                // 若缓存已满，则移除指标值最小的元素。
                removeElement();
            }
            count.put(key, new HitRate(key, 1, System.nanoTime()));
        } else {
            // 更新元素的访问状态信息
            addHitCount(key);
        }

        cache.put(key, value);
    }

    /**
     * 获取key对应的value。
     *
     * @param key key值
     * @return key对应的value
     */
    public v get(k key) {
        v value = cache.get(key);
        if (value != null) {
            // 更新元素的访问状态信息
            addHitCount(key);
            return value;
        }

        return null;
    }

    // 移除元素
    private void removeElement() {
        // 返回给定集合中指标值最小的元素
        HitRate hr = Collections.min(count.values());
        cache.remove(hr.key);
        count.remove(hr.key);
    }

    // 更新元素的访问状态信息
    private void addHitCount(k key) {
        HitRate hitRate = count.get(key);
        hitRate.hitCount = hitRate.hitCount + 1;
        hitRate.lastTime = System.nanoTime();
    }

    // 内部类
    class HitRate implements Comparable<HitRate> {
        /**
         * 访问的key
         */
        private k key;
        /**
         * 命中次数
         */
        private int hitCount;
        /**
         * 上次访问时间
         */
        private long lastTime;

        private HitRate(k key, int hitCount, long lastTime) {
            this.key = key;
            this.hitCount = hitCount;
            this.lastTime = lastTime;
        }

        @Override
        public int compareTo(HitRate o) {
            // 按照升序排序
            int compare = Integer.compare(this.hitCount, o.hitCount);
            return compare == 0 ? Long.compare(this.lastTime, o.lastTime) : compare;
        }
    }

    void getShowValue(k key) {
        String row = (key + "=" + this.get(key));
        if (Objects.nonNull(count.get(key))) {
            row += ", hitCount=" + count.get(key).hitCount;
        }

        System.out.println(row);
    }

    public static void main(String[] args) {
        LFUCache<String, Integer> lfuCache = new LFUCache<>(3);
        lfuCache.put("key1", 1);
        lfuCache.put("key2", 2);

        String key = "key1";
        lfuCache.getShowValue(key);
        key = "key2";
        lfuCache.getShowValue(key);
        key = "key1";
        lfuCache.getShowValue(key);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        lfuCache.put("key3", 3);
        lfuCache.put("key4", 4);

        // key1、key2元素都有访问次数，放入key3后缓存满；加入key4时，由于key3的访问次数最小，淘汰key3。
        key = "key3";
        lfuCache.getShowValue(key);
        key = "key1";
        lfuCache.getShowValue(key);
        key = "key4";
        lfuCache.getShowValue(key);

        lfuCache.put("key5", 5);
        // 目前key1访问4次，key2访问2次，key4访问2次。由于key4的时间比较新，放入key5的时候，移除key2元素。
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        lfuCache.cache.forEach((key1, value) -> System.out.println(key1 + " : " + value));
    }
}
