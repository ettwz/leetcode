package com.mine.leetcode.cn.no1028;

import java.util.*;

class Solution {

  public TreeNode recoverFromPreorder(String S) {
    Deque<TreeNode> path = new LinkedList<>();
    int index = 0;
    while (index < S.length()) {
      int depth = 0;
      while (S.charAt(index) == '-') {
        ++depth;
        ++index;
      }
      int value = 0;
      while (index < S.length() && Character.isDigit(S.charAt(index))) {
        value = value * 10 + (S.charAt(index) - '0');
        ++index;
      }
      TreeNode treeNode = new TreeNode(value);
      if (depth == path.size()) {
        if (!path.isEmpty()) {
          path.peekFirst().left = treeNode;
        }
      } else {
        while (depth != path.size()) {
          path.removeFirst();
        }
        path.peekFirst().right = treeNode;
      }
      path.push(treeNode);
    }
    while (path.size() > 1) {
      path.removeFirst();
    }

    return path.peek();
  }
}