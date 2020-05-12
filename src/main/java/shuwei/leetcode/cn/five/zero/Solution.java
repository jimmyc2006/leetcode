package shuwei.leetcode.cn.five.zero;

public class Solution {
  
  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 1 / powi(x, -(long)n);
    } else {
      return powi(x, n);
    }
  }
  
  private double powi(double x, long n) {
    if (n == 1) {
      return x;
    }
    if (n % 2 == 0) {
      return powi(x * x, n / 2);
    } else {
      return powi(x * x, n / 2) * x;
    }
  }
}
