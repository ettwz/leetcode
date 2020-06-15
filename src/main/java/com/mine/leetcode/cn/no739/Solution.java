package com.mine.leetcode.cn.no739;

import java.util.Stack;

class Solution {

  public int[] dailyTemperatures(int[] T) {
    Stack<Integer> stack = new Stack<>();
    int[] result = new int[T.length];

    for (int i = 0; i < T.length; i++) {
      while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
        int per = stack.pop();
        result[per] = i - per;
      }
      stack.add(i);
    }

    return result;
  }
}
