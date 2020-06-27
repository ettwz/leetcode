package com.mine.leetcode.cn.no139;

import java.util.*;

public class Solution {
    private HashMap<String, Boolean> wordDictHashMap = new HashMap<>();
    
    public boolean wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict) {
            wordDictHashMap.put(word, true);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int j = 1; j <= s.length(); j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[j] = dp[i] && check(s.substring(i, j));
                if (dp[j]) break;
            }
        }
        
        return dp[s.length()];
    }
    
    private boolean check(String s) {
        return wordDictHashMap.getOrDefault(s, false);
    }
}
