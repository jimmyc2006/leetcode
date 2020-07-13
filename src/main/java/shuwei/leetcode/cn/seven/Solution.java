package shuwei.leetcode.cn.seven;

public class Solution {

  public int reverse(int x) {
    if (x < 0) {
      return -rever(-x);
    } else {
      return rever(x);
    }
  }
  private int rever(int p) {
    int ans = 0;
    while (p > 0) {
      int remain = p % 10;
      if (ans > (Integer.MAX_VALUE - remain) / 10) {
        return 0;
      }
      ans = 10 * ans + remain;
      p = p / 10;
    }
    return ans;
  }
}

