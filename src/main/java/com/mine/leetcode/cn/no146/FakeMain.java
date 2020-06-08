package com.mine.leetcode.cn.no146;

public class FakeMain {
    public void fakeMain() {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);
        
        MineLRUCache mineLRUCache = new MineLRUCache(2 /* 缓存容量 */);
        
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));        // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
        
        mineLRUCache.put(2, 1);
        mineLRUCache.put(2, 2);
        System.out.println(mineLRUCache.get(2));       // 返回  4
        mineLRUCache.put(1, 1);
        mineLRUCache.put(4, 1);
        System.out.println(mineLRUCache.get(2));       // 返回  4
    }
}
