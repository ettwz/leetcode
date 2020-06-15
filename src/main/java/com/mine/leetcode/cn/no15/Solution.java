package com.mine.leetcode.cn.no15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        return list;
      }

      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int l = i + 1;
      int r = nums.length - 1;

      while (l < r) {
        int res = nums[i] + nums[l] + nums[r];

        if (res == 0) {
          List<Integer> resList = new ArrayList<>();
          resList.add(nums[i]);
          resList.add(nums[l]);
          resList.add(nums[r]);

          list.add(resList);

          while (l < r && nums[l] == nums[l + 1]) {
            ++l;
          }

          ++l;
          --r;
        } else if (res < 0) {
          ++l;
        } else {
          --r;
        }
      }
    }
    return list;
  }
}