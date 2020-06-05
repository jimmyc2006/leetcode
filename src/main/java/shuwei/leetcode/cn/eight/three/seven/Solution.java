package shuwei.leetcode.cn.eight.three.seven;

public class Solution {
  // dp思路
  // 从K - 1开始计算
  // 例如N=30, K =24;W=10,则:
  // f[23]的成功数是24,25...30,30-23=7,也就是1-7不会超过30，那么概率应该是7 / W
  // f[22]的成功概率，选中1的时候，1 / W * f[23] + 前面是1，那么后面就是 (7 - 1 )/ W
  // f[21]的成功率, 1 / W * f[22] + 1 / W * f[23] + 前面是2，那么后面就是(7 - 2) /W
  // f[13]的成功率，1 / W * f[14] + 1 / W * f[15] + ... + 1 / W * f[23] = (1 / W)(f[14] + f[15] + ... + f[23])
  // 有个循环数是从0到W
  // 3ms 100%
  public double new21Game(int N, int K, int W) {
    if (K == 0) {
      return 1;
    }
    double[] f = new double[K]; // 0到K-1
    double DW = (double) W;
    int diff = N - (K - 1);
    if (diff >= W) {
      return 1;
    }
    double a = diff / DW;
    double b = 1 / DW;
    double sum = 0;
    for (int i = K - 1, j = 1; i >= 0; i--,j++) {
      if (j > 1) {
        sum = sum + f[i + 1];
      }
      if (j > W + 1) {
        sum = sum - f[i + W + 1];
      }
      if (W > j - 1) {
        if (diff + j - 1 <= W) {
          f[i] = b * sum + a;
        } else {
          f[i] = b * sum + (W - j + 1) / DW;
        }
      } else {
        f[i] = b * sum;
      }
    }
    return f[0];
  }
}
