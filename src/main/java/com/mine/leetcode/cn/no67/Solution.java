package com.mine.leetcode.cn.no67;

import java.util.Stack;

public class Solution {

  public String addBinary(String a, String b) {
    Stack<Integer> res = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    while (i >= 0 || j >= 0 || carry != 0) {
      carry += i >= 0 ? a.charAt(i--) - '0' : 0;
      carry += j >= 0 ? b.charAt(j--) - '0' : 0;
      res.push(carry % 2);
      carry = carry / 2;
    }

    while (!res.isEmpty()) {
      sb.append(res.pop());
    }
    return sb.toString();
  }
}
