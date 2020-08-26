package shuwei.leetcode.cn.five.four.six;

public class Solution {
  /**
   * 思路：动态规划，每次往后多加一个数字，如果这个数字跟前面的某一个数字相等，就多一种算法 最后比较算法最大值，每次只处理新加的数值 f[i][j]表示从i到j的最大值
   */
  public int removeBoxes(int[] boxes) {
    int length = boxes.length;
    dp = new int[length][length][length];
    calculate(boxes, 0, length - 1, 0);
    return dp[0][length - 1][0];
  }

  int[][][] dp;

  // 包含left和right
  private int calculate(int[] boxes, int left, int right, int k) {
    if (left > right) {
      return 0;
    }
    if (dp[left][right][k] != 0) {
      return dp[left][right][k];
    }
    // 1, 3, 2, 2, 2, 3, 4, 3, 1
    dp[left][right][k] = calculate(boxes, left, right - 1, 0) + (k + 1) * (k + 1);
    for (int i = left; i < right; i++) {
      if (boxes[i] == boxes[right]) {
        dp[left][right][k] = Math.max(dp[left][right][k],
                calculate(boxes, left, i, k + 1) + calculate(boxes, i + 1, right - 1, 0));
      }
    }
    return dp[left][right][k];
  }
}
