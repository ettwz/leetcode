package com.mine.leetcode.cn.no209;

public class Solution {

  public int minSubArrayLen(int s, int[] nums) {
    int length = nums.length;
    if (length == 0) {
      return 0;
    }

    int ans = Integer.MAX_VALUE;
    int start = 0;
    int end = 0;
    int sum = 0;

    while (end < length) {
      sum += nums[end];
      while (sum >= s) {
        ans = Math.min(ans, end - start + 1);
        sum -= nums[start];
        start++;
      }
      end++;
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }
}
