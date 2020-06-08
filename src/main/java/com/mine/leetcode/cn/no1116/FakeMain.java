package com.mine.leetcode.cn.no1116;

import java.util.function.IntConsumer;

public class FakeMain {
    public void fakeMain() {
        IntConsumer intConsumer = new IntConsumerImpl();
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        Thread thread0 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread1 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread0.start();
        thread1.start();
        thread2.start();
    }
}
