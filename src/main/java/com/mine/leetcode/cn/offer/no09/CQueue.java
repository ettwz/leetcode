package com.mine.leetcode.cn.offer.no09;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Your CQueue object will be instantiated and called as such: CQueue obj = new CQueue();
 * obj.appendTail(value); int param_2 = obj.deleteHead();
 */

public class CQueue {

  Deque<Integer> stack1;
  Deque<Integer> stack2;
  int size = 0;

  public CQueue() {
    stack1 = new LinkedList<Integer>();
    stack2 = new LinkedList<Integer>();
  }

  public void appendTail(int value) {
    stack1.push(value);
    size++;
  }

  public int deleteHead() {
    if (size == 0) {
      return -1;
    }
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    size--;
    return stack2.pop();
  }
}
