package com.mine.leetcode.cn.no1116;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }
    
    private Semaphore semaphore0 = new Semaphore(1);
    private Semaphore semaphoreOdd = new Semaphore(0);
    private Semaphore semaphoreEven = new Semaphore(0);
    
    
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int a = 0; a < n; a++) {
            semaphore0.acquire();
            printNumber.accept(0);
            if ((a & 1) == 0) {
                semaphoreOdd.release();
            } else {
                semaphoreEven.release();
            }
        }
    }
    
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int a = 2; a <= n; a = a + 2) {
            semaphoreEven.acquire();
            printNumber.accept(a);
            semaphore0.release();
        }
    }
    
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int a = 1; a <= n; a = a + 2) {
            semaphoreOdd.acquire();
            printNumber.accept(a);
            semaphore0.release();
        }
    }
}
