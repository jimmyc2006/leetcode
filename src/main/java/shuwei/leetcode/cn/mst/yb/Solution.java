package shuwei.leetcode.cn.mst.yb;

/**
 * @author shuwei
 * @version 创建时间：2020年4月23日 上午9:08:48 类说明
 */
public class Solution {
  private int[] mz = new int[] {1, 5, 10, 25};
  // 改为不递归
  // 53ms,21%
  // TODO 继续优化，熟悉背包算法
  public int waysToChange(int n) {
    int[][] res = new int[mz.length + 1][n + 1];
    for (int i = 1; i <= 4; i++) {
      res[i][0] = 1;
    }
    for (int i = 0; i < 4; i++) {
      for (int j = 1; j <= n; j++) {
        if (j >= mz[i]) {
          res[i + 1][j] = (res[i][j] + res[i + 1][j - mz[i]]) % 1000000007;
        } else {
          res[i + 1][j] = res[i][j];
        }
      }
    }
    return res[4][n];
  }

  // 仍然超时
  public int package1(int maxIndex, int n) {
    if (n == 0 || maxIndex == 0) {
      return 1;
    }
    int sum;
    if (n >= mz[maxIndex]) {
      sum = package1(maxIndex - 1, n) + package1(maxIndex, n - mz[maxIndex]) % 1000000007;
    } else {
      sum = package1(maxIndex - 1, n) % 1000000007;
    }
    return sum;
  }

  // 最初的背包，不能通过性能测试
  public int package2(int maxIndex, int n) {
    if (n == 0 || maxIndex == 0) {
      return 1;
    }
    int sum = 0;
    for (int i = 0; n - mz[maxIndex] * i >= 0; i++) {
      sum += package2(maxIndex - 1, n - mz[maxIndex] * i);
    }
    return sum;
  }
}
