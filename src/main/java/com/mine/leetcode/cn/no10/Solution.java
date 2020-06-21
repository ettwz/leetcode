package com.mine.leetcode.cn.no10;

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int sIndex = 0, pIndex = 0;
        return matchCore(s, sIndex, p, pIndex);
    }
    
    public boolean matchCore(String s, int sIndex, String p, int pIndex) {
        if (sIndex == s.length() && pIndex == p.length()) return true;
        if (sIndex < s.length() && pIndex == p.length()) return false;
        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            if ((sIndex < s.length() && p.charAt(pIndex) == s.charAt(sIndex)) || (sIndex < s.length() && p.charAt(pIndex) == '.')) {
                return matchCore(s, sIndex + 1, p, pIndex) || matchCore(s, sIndex, p, pIndex + 2);
            } else {
                return matchCore(s, sIndex, p, pIndex + 2);
            }
        } else {
            if ((sIndex < s.length() && p.charAt(pIndex) == s.charAt(sIndex)) || (sIndex < s.length() && p.charAt(pIndex) == '.')) {
                return matchCore(s, sIndex + 1, p, pIndex + 1);
            } else {
                return false;
            }
        }
    }
}
