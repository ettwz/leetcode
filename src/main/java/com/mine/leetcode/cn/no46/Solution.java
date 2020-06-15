package com.mine.leetcode.cn.no46;

class Solution {

  public int translateNum(int num) {
    String str = String.valueOf(num);
    return dfs(str, 0);
  }

  public int dfs(String num, int index) {
    if (index > num.length() - 2) {
      return 1;
    }
    int res = 0;

    res += dfs(num, index + 1);

    if (num.charAt(index) != '0' && index < num.length() - 1) {
      int value = (num.charAt(index) - '0') * 10 + (num.charAt(index + 1) - '0');
      if (value < 26) {
        res += dfs(num, index + 2);
      }
    }
    return res;
  }
}