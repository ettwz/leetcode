package com.mine.leetcode.cn.no297;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder res = new StringBuilder("[");
    Queue<TreeNode> treeNodes = new LinkedList<>();
    treeNodes.add(root);
    while (!treeNodes.isEmpty()) {
      TreeNode cur = treeNodes.remove();
      if (cur == null) {
        res.append("null,");
      } else {
        res.append(cur.val).append(",");
        treeNodes.add(cur.left);
        treeNodes.add(cur.right);
      }
    }
    res.append("]");
    return res.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] nodes = data.substring(1, data.length() - 1).split(",");
    TreeNode root = buildNode(nodes[0]);
    Queue<TreeNode> treeNodes = new LinkedList<>();
    TreeNode parent = root;
    boolean isLeft = true;
    for (int i = 1; i < nodes.length; i++) {
      TreeNode cur = buildNode(nodes[i]);
      if (isLeft) {
        parent.left = cur;
      } else {
        parent.right = cur;
      }
      if (cur != null) {
        treeNodes.add(cur);
      }
      if (!isLeft) {
        parent = treeNodes.poll();
      }
      isLeft = !isLeft;
    }
    return root;
  }

  private TreeNode buildNode(String val) {
    if (val.equals("null")) {
      return null;
    } else {
      return new TreeNode(Integer.parseInt(val));
    }
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));