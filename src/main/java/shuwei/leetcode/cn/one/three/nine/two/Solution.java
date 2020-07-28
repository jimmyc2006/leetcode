package shuwei.leetcode.cn.one.three.nine.two;

public class Solution {
  public boolean isSubsequence(String s, String t) {
    if (s.length() < 1) {
      return true;
    }
    char[] cs = s.toCharArray();
    char[] ct = t.toCharArray();
    for (int i = 0, j = 0; j < ct.length; j++) {
      if (cs[i] == ct[j]) {
        i++;
        if (i == cs.length) {
          return true;
        }
      }
    }
    return false;
  }
}
