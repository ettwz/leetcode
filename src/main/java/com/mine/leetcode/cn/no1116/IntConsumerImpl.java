package com.mine.leetcode.cn.no1116;

import java.util.function.IntConsumer;

public class IntConsumerImpl implements IntConsumer {
    @Override
    public void accept(int value) {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + ":" + value);
    }
    
    @Override
    public IntConsumer andThen(IntConsumer after) {
        return null;
    }
}
