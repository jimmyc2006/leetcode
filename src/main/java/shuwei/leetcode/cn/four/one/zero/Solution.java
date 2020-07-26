package shuwei.leetcode.cn.four.one.zero;

import java.util.Arrays;

public class Solution {
  public int splitArray(int[] nums, int m) {
    int[][] dp = new int[nums.length + 1][m + 1];
    int[] totalSums = new int[nums.length];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      totalSums[i] = sum;
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    Arrays.fill(dp[nums.length], Integer.MAX_VALUE);
    // 截止到下标+1
    for (int i = 1; i <= nums.length; i++) {
      // 分为几组
      for (int j = 1; j <= i && j <= m; j++) {
        if (j == 1) {
          dp[i][j] = totalSums[i - 1];
        } else {
          // 最后几个分为一组
          for (int k = 1; i - k >= j - 1; k++) {
            int max = Math.max(dp[i - k][j - 1], totalSums[i - 1] - totalSums[i - k - 1]);
            dp[i][j] = Math.min(dp[i][j], max);
          }
        }
      }
    }
    return dp[nums.length][m];
  }
}
