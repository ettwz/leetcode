package com.mine.leetcode.cn.no125;

public class Solution {

  public boolean isPalindrome(String s) {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < s.length(); i++) {
      char t = s.charAt(i);
      if (Character.isLetterOrDigit(t)) {
        stringBuffer.append(Character.toLowerCase(t));
      }
    }
    return stringBuffer.toString().equals(stringBuffer.reverse().toString());
  }
}
