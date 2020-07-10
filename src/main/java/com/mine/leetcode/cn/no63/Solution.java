package com.mine.leetcode.cn.no63;

public class Solution {

  public int uniquePathsWithObstacles(int[][] ob) {
    int m = ob.length;
    int n = ob[0].length;
    if (m == 0 || n == 0) {
      return 0;
    }
    // `ob[i][j] == 1`表示无障碍物，`dp[i][j] = dp[i - 1][j] + d[i][j - 1]`
    int[][] dp = new int[m][n];
    // 初始化
    // 第0行和第0列分别遍历，赋值为1；
    // 如果碰到障碍物，从这个点之后全为0，因为碰到障碍物，之后都不可达了。
    for (int i = 0; i < m; i++) {
      if (ob[i][0] == 1) {
        break;
      } else {
        dp[i][0] = 1;
      }
    }
    for (int i = 0; i < n; i++) {
      if (ob[0][i] == 1) {
        break;
      } else {
        dp[0][i] = 1;
      }
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        // `ob[i][j] == 1`表示有障碍物，直接令`dp[i][j] = 0`;
        if (ob[i][j] == 1) {
          dp[i][j] = 0;
        }
        // `ob[i][j] == 1`表示无障碍物，`dp[i][j] = dp[i - 1][j] + d[i][j - 1]`
        else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[m - 1][n - 1];
  }
}
