package shuwei.leetcode.cn.seven.zero;

public class Solution {
  // f[x] = f[x - 1] * f[x - 2]
  public int climbStairs(int n) {
    if (n < 3) {
      return n;
    }
    int[] f = new int[n];
    f[0] = 1;
    f[1] = 2;
    for (int i = 2; i < n; i++) {
      f[i] = f[i - 1] + f[i - 2];
    }
    return f[n - 1];
  }
}
