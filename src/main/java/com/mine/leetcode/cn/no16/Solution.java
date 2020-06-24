package com.mine.leetcode.cn.no16;

import java.util.*;

public class Solution {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int length = nums.length;
    int best = 10000000;
    for (int i = 0; i < length; i++) {
      if (i > 1 && nums[i] == nums[i - 1]) {
        continue;
      }
      int j = i + 1;
      int k = length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == target) {
          return target;
        }
        System.out.println(Math.abs(sum - target));
        System.out.println(Math.abs(best - target));
        if (Math.abs(sum - target) < Math.abs(best - target)) {
          best = sum;
        }
        if (sum > target) {
          int k0 = k - 1;
          while (j < k0 && nums[k0] == nums[k]) {
            k0--;
          }
          k = k0;
        } else {
          int j0 = j + 1;
          while (j0 < k && nums[j0] == nums[j]) {
            j0++;
          }
          j = j0;
        }
      }
    }
    return best;
  }
}
