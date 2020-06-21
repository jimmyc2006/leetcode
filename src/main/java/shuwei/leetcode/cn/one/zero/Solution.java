package shuwei.leetcode.cn.one.zero;

public class Solution {
  public boolean isMatch(String s, String p) {
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
