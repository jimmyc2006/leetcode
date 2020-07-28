package shuwei.leetcode.cn.nine;

public class Solution {
  // 这里的(x % 10 == 0 && x != 0)有点玄学
  public boolean isPalindrome(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }
    int reverse = 0;
    while (x > reverse) {
      reverse = reverse * 10 + x % 10;
      x = x / 10;
    }
    return x == reverse || x == reverse / 10;
  }

  public boolean isPalindrome1(int x) {
    if (x < 0) {
      return false;
    }
    int reverse = 0;
    int tmp = x;
    while (tmp > 0) {
      reverse = reverse * 10 + tmp % 10;
      tmp = tmp / 10;
    }
    return reverse == x;
  }
}
