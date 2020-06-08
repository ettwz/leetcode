package com.mine.leetcode.cn.no146;


import java.util.Hashtable;

public class MineLRUCache {
    
    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode start;
    private DLinkedNode end;
    
    private class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        
        private DLinkedNode() {
        
        }
        
        private DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private DLinkedNode addNode(DLinkedNode node) {
        node.prev = start;
        node.next = start.next;
        
        start.next.prev = node;
        start.next = node;
        
        return node;
    }
    
    private void deleteNode(DLinkedNode node) {
        DLinkedNode next = node.next;
        DLinkedNode prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }
    
    private void moveToTop(DLinkedNode node) {
        deleteNode(node);
        addNode(node);
    }
    
    private DLinkedNode popEnd() {
        DLinkedNode node = end.prev;
        deleteNode(node);
        --size;
        return node;
    }
    
    public MineLRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        start = new DLinkedNode();
        end = new DLinkedNode();
        
        start.next = end;
        end.prev = start;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            moveToTop(node);
            return node.value;
        } else return -1;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            if (size == capacity) {
                cache.remove(popEnd().key);
            }
            cache.put(key, addNode(new DLinkedNode(key, value)));
            size++;
        } else {
            node.value = value;
            moveToTop(node);
        }
    }
}
