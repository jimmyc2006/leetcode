package shuwei.leetcode.cn.nine.seven;

public class Solution {
  // 为true就表示不匹配
  boolean[][] storage;
  char[] c1, c2, c3;
  public boolean isInterleave(String s1, String s2, String s3) {
    storage = new boolean[s1.length() + 1][s2.length() + 1];
    if (s3.length() != s1.length() + s2.length()) {
      return false;
    }
    c1 = s1.toCharArray();
    c2 = s2.toCharArray();
    c3 = s3.toCharArray();
    return mathch(0, 0, 0);
  }
  private boolean mathch(int index1, int index2, int index3) {
    if (storage[index1][index2]) {
      return false;
    }
    if (index1 == c1.length && index2 == c2.length) {
      return true;
    }
    if (index1 < c1.length && c3[index3] == c1[index1]) {
      if (mathch(index1 + 1, index2, index3 + 1)) {
        return true;
      }
    }
    if (index2 < c2.length && c3[index3] == c2[index2]) {
      if (mathch(index1, index2 + 1, index3 + 1)) {
        return true;
      }
    }
    storage[index1][index2] = true;
    return false;
  }
}
