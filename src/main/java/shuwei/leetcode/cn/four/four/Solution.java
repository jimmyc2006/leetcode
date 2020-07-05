package shuwei.leetcode.cn.four.four;

public class Solution {
  public boolean isMatch(String s, String p) {
    if (p.length() < 1) {
      return s.length() < 1;
    }
    if (s.length() < 1) {
      return p.replace("*", "").length() < 1;
    }
    char[] sChars = s.toCharArray();
    char[] pChars = p.toCharArray();
    int lengthS = sChars.length, lengthP = pChars.length;
    boolean[][] f = new boolean[lengthP + 1][lengthS + 1];
    f[0][0] = true;
    // 如果正则第一个字符是*,初始化s为空的时候为true
    for (int i = 1; i < lengthP; i++) {
      if (pChars[i - 1] == '*') {
        f[i][0] = true;
      } else {
        break;
      }
    }
    for (int i = 1; i <= lengthP; i++) {
      for (int j = 1; j <= lengthS; j++) {
        if (pChars[i - 1] == '*') {
          f[i][j] = f[i - 1][j - 1] || f[i - 1][j] || f[i][j - 1];
        } else {
          if (pChars[i - 1] == '?' || pChars[i - 1] == sChars[j - 1]) {
            f[i][j] = f[i - 1][j - 1];
          }
        }
      }
    }
    return f[lengthP][lengthS];
  }
}