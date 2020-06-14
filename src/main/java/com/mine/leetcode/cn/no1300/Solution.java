package com.mine.leetcode.cn.no1300;

import java.util.Arrays;

public class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        int sum = 0;
        
        for (int i = 0; i < len; i++) {
            int curAve = getAverageValue(len - i, target - sum);
            if (curAve <= arr[i]) {
                return curAve;
            }
            sum += arr[i];
        }
        return arr[len - 1];
    }
    
    public int getAverageValue(int arrLength, int target) {
        double a = target * 1.0 / arrLength * 1.0;
        int b = (int) a;
        if (a - b < 0.6) {
            return b;
        } else {
            return b + 1;
        }
    }
}
