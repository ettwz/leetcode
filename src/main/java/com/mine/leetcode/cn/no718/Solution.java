package com.mine.leetcode.cn.no718;

public class Solution {

  public int findLength(int[] A, int[] B) {
    int a = A.length;
    int b = B.length;
    int res = 0;

    for (int i = 0; i < a; i++) {
      int length = Math.min(b, a - i);
      int maxlen = maxLength(A, B, i, 0, length);
      res = Math.max(res, maxlen);
    }

    for (int i = 0; i < b; i++) {
      int length = Math.min(a, b - i);
      int maxlen = maxLength(A, B, 0, i, length);
      res = Math.max(res, maxlen);
    }
    return res;
  }

  private int maxLength(int[] A, int[] B, int addA, int addB, int length) {
    int res = 0;
    int k = 0;
    for (int i = 0; i < length; i++) {
      if (A[addA + i] == B[addB + i]) {
        k++;
      } else {
        k = 0;
      }
      res = Math.max(res, k);
    }
    return res;
  }
}
