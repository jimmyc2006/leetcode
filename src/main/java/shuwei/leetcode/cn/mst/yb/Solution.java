package shuwei.leetcode.cn.mst.yb;

public class Solution {
  int[] MZ = new int[]{0, 1, 5, 10, 25};

  // 多重背包问题
  // f[x][y]表示剩余硬币x,单个硬币的取值可以从y开始
  public int waysToChange(int n) {
    int[][] dp = new int[MZ.length][n + 1];
    for (int i = 0; i < MZ.length; i++) {
      dp[i][0] = 1;
    }
    for (int x = 1; x < MZ.length; x++) {
      for (int y = 1; y <= n; y++) {
        if (y >= MZ[x]) {
          dp[x][y] = dp[x][y - MZ[x]] + dp[x - 1][y];
        } else {
          dp[x][y] = dp[x - 1][y];
        }
        if (dp[x][y] > 1000000007) {
          dp[x][y] = dp[x][y] % 1000000007;
        }
      }
    }
    return dp[MZ.length - 1][n];
  }
}
