package shuwei.leetcode.cn.eight;

public class Solution {
  public int myAtoi(String str) {
    char[] chars = str.trim().toCharArray();
    if (chars.length < 1) {
      return 0;
    }
    boolean isNegative;
    int ans = 0;
    int i = 1;
    if (chars[0] == '-') {
      isNegative = true;
    } else if (chars[0] == '+') {
      isNegative = false;
    } else if (chars[0] >= '0' && chars[0] <= '9') {
      isNegative = false;
      i = 0;
    } else {
      return 0;
    }
    for (; i < chars.length; i++) {
      if (chars[i] >= '0' && chars[i] <= '9') {
        int gewei = chars[i] - '0';
        if (isNegative) {
          if (ans < (Integer.MIN_VALUE + gewei) / 10 ) {
            return Integer.MIN_VALUE;
          } else {
            ans = ans * 10 - gewei;
          }
        } else {
          if (ans > (Integer.MAX_VALUE - gewei) / 10){
            return Integer.MAX_VALUE;
          } else {
            ans = ans * 10 + gewei;
          }
        }
      } else {
        break;
      }
    }
    return ans;
  }
}
