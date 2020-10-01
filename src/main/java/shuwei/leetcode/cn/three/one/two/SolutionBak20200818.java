package shuwei.leetcode.cn.three.one.two;

public class SolutionBak20200818 {

  public int maxCoins(int[] nums) {
    int n = nums.length;
    int[][] rec = new int[n + 2][n + 2];
    int[] val = new int[n + 2];
    val[0] = val[n + 1] = 1;
    for (int i = 1; i <= n; i++) {
      val[i] = nums[i - 1];
    }
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i + 2; j <= n + 1; j++) {
        for (int k = i + 1; k < j; k++) {
          int sum = val[i] * val[k] * val[j];
          sum += rec[i][k] + rec[k][j];
          rec[i][j] = Math.max(rec[i][j], sum);
        }
      }
    }
    return rec[0][n + 1];
  }

  public int maxCoins1(int[] nums) {
    int len = nums.length;
    int[][] f = new int[len][len];
    for (int i = len - 1; i >= 0; i--) {
      f[i][i] = nums[i];
      for (int j = i + 1; j < len; j++) {
        for (int k = i; k <= j; k++) {
          int val = nums[k];
          if (k > i) {
            val = nums[i] * val;
          }
          if (k < j) {
            val = val * nums[j];
          }
          if (k == i) {
            f[i][j] = Math.max(f[i][j], val + f[k + 1][j]);
          } else if (k == j) {
            f[i][j] = Math.max(f[i][j], f[i][k - 1] + val);
          } else {
            f[i][j] = Math.max(f[i][j], f[i][k - 1] + val + f[k + 1][j]);
          }
        }
      }
    }
    return f[0][len - 1];
  }
}
