package com.mine.leetcode.cn.no378;

public class Solution {

  public int kthSmallest(int[][] matrix, int k) {
    int length = matrix.length;
    int left = matrix[0][0];
    int right = matrix[length - 1][length - 1];
    while (left < right) {
      int mid = left + ((right - left) >> 1);
      if (check(matrix, mid, k, length)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private boolean check(int[][] matrix, int mid, int k, int length) {
    int i = length - 1;
    int j = 0;
    int num = 0;
    while (i >= 0 && j < length) {
      if (matrix[i][j] <= mid) {
        num += i + 1;
        j++;
      } else {
        i--;
      }
    }
    return num >= k;
  }

}
