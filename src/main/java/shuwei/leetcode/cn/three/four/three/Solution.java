package shuwei.leetcode.cn.three.four.three;

public class Solution {
  public int integerBreak(int n) {
    int[] dp =  new int[n + 1];
    dp[2] = 1;
    for (int i = 3; i <=n; i++) {
      for (int j = 1; j <= i / 2; j++) {
        dp[i] = Math.max(dp[i], j * (i - j));
        dp[i] = Math.max(dp[i], j * dp[i - j]);
      }
    }
    return dp[n];
  }
}
