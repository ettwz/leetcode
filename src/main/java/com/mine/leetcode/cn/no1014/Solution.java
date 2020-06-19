package com.mine.leetcode.cn.no1014;

class Solution {

  public int maxScoreSightseeingPair(int[] A) {
    int res = 0;
    int max = 0;
    for (int i = 0; i < A.length; i++) {
      res = Math.max(res, max + A[i] - i);
      max = Math.max(max, A[i] + i);
    }
    return res;
  }
}
