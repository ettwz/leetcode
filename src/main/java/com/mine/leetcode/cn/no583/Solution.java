package com.mine.leetcode.cn.no583;

public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int a = 0; a <= word1.length(); a++) {
            for (int b = 0; b <= word2.length(); b++) {
                if (a == 0 || b == 0) {
                    continue;
                }
                if (word1.charAt(a - 1) == word2.charAt(b - 1)) {
                    dp[a][b] = 1 + dp[a - 1][b - 1];
                } else {
                    dp[a][b] = Math.max(dp[a - 1][b], dp[a][b - 1]);
                }
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }
}