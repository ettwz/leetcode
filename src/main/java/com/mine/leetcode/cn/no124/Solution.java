package com.mine.leetcode.cn.no124;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
        maxGain(root);
        return maxSum;
    }
    
    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = maxGain(node.left);
        int right = maxGain(node.right);
        
        int sum = node.val + Math.max(0, left) + Math.max(0, right);
        int path = node.val + Math.max(0, Math.max(left, right));
        
        maxSum = Math.max(maxSum, sum);
        return path;
    }
    
}
