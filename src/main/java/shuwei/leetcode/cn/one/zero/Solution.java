package shuwei.leetcode.cn.one.zero;

public class Solution {

  // dp解法
  public boolean isMatch(String s, String p) {
    boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
    f[0][0] = true;
    for (int i = 0; i <= s.length(); i++) {
      for (int j = 1; j <= p.length(); j++) {
        // j = 0表示空串，那么j = 1表示字符串的第一个
        if (p.charAt(j - 1) == '*') {
          f[i][j] = f[i][j - 2];
          if (isM(s, p, i, j - 1)) {
            f[i][j] = f[i - 1][j] || f[i][j - 2];
          }
        } else {
          if (isM(s, p, i, j)) {
            f[i][j] = f[i - 1][j - 1];
          } else {
            f[i][j] = false;
          }
        }
      }
    }
    return f[s.length()][p.length()];
  }

  private boolean isM(String s, String p, int i, int j) {
    if (i == 0) {
      return false;
    }
    return (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
  }


  public boolean isMatch1(String s, String p) {
    if (s == null || p == null) {
      return false;
    }
    return match(s.toCharArray(), 0, p.toCharArray(), 0);
  }

  // "ab", ".*c"
  private boolean match(char[] content, int i, char[] pattern, int j) {
    if (i >= content.length) {
      if (j >= pattern.length) {
        return true;
      } else {
        if (j + 1 < pattern.length && pattern[j + 1] == '*') {
          return match(content, i, pattern, j + 2);
        } else {
          return false;
        }
      }
    }
    if (j >= pattern.length) {
      return false;
    }
    if (j + 1 < pattern.length && pattern[j + 1] == '*') {
      return mat(content, i, pattern, j + 2, pattern[j]);
    } else if (content[i] == pattern[j] || pattern[j] == '.') {
      return match(content, i + 1, pattern, j + 1);
    } else {
      return false;
    }
  }

  // "ab", ".*c"
  private boolean mat(char[] content, int i, char[] pattern, int j, char pre) {
    if (j >= pattern.length) {
      return matTilEnd(content, i, pre);
    }
    if (i >= content.length) {
      return match(content, i, pattern, j);
    }
    if (match(content, i, pattern, j)) {
      return true;
    } else {
      if (content[i] == pre || pre == '.') {
        return mat(content, i + 1, pattern, j, pre);
      } else {
        return match(content, i, pattern, j);
      }
    }
  }

  private boolean matTilEnd(char[] content, int i, char pre) {
    if (pre == '.' || i >= content.length) {
      return true;
    } else {
      while (i < content.length && content[i] == pre) {
        i++;
      }
      return i >= content.length;
    }
  }
}
