package com.mine.leetcode.cn.no1029;

import java.util.Arrays;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int length = costs.length;
        int cost = 0;
        int[] costsAReduceB = new int[length];
        
        for (int a = 0; a < length; a++) {
            cost = cost + costs[a][0];
            costsAReduceB[a] = costs[a][1] - costs[a][0];
        }
        
        Arrays.sort(costsAReduceB);
        
        for (int b = 0; b < length / 2; b++) {
            cost = cost + costsAReduceB[b];
        }
        
        return cost;
    }
}