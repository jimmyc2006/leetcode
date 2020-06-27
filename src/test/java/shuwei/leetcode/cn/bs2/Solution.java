package shuwei.leetcode.cn.bs2;

public class Solution {
  public int kthFactor(int n, int k) {
    boolean[] inzi = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
      if (inzi[i]) {
        break;
      }
      if (n % i == 0) {
        inzi[i] = true;
        inzi[n / i] = true;
      }
    }
    int count = 0;
    for (int i = 1; i <= n; i++) {
      if(inzi[i]) {
        count++;
        if (count == k) {
          return i;
        }
      }
    }
    return -1;
  }
}
