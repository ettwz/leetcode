package com.mine.leetcode.cn.no135;

import java.util.Arrays;

public class Solution {
    public int candy(int[] ratings) {
        int sum = 0;
        int length = ratings.length;
        int[] numsLeft = new int[length];
        int[] numsRight = new int[length];
        Arrays.fill(numsLeft, 1);
        Arrays.fill(numsRight, 1);
        
        for (int a = 1; a < length; a++) {
            if (ratings[a - 1] < ratings[a]) {
                numsLeft[a] = numsLeft[a - 1] + 1;
            }
        }
        
        for (int a = length - 2; a >= 0; a--) {
            if (ratings[a] > ratings[a + 1]) {
                numsRight[a] = numsRight[a + 1] + 1;
            }
        }
        
        for (int a = 0; a < length; a++) {
            sum += Math.max(numsLeft[a], numsRight[a]);
        }
        return sum;
    }
}
