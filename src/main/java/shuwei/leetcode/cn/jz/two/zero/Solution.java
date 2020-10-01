package shuwei.leetcode.cn.jz.two.zero;

public class Solution {

  /**
   * +和-只能出现再开头或者E/e后面 .和e只能出现一次，且不能在开头和结尾 非数值或者+-e.都认为匹配失败 e后面不能出现.
   */
  public boolean isNumber(String s) {
    char[] content = s.trim().toCharArray();
    int eCount = 0, dotCount = 0;
    int numCount = 0;
    for (int i = 0; i < content.length; i++) {
      if (isNumber(content[i])) {
        numCount++;
        continue;
      } else if (isE(content[i])) {
        if (eCount > 0 || numCount == 0) {
          return false;
        } else if (i == 0 || i == content.length - 1) {
          return false;
        } else {
          eCount++;
        }
      } else if (content[i] == '-' || content[i] == '+') {
        if (i == 0) {
          if (i + 1 < content.length && (isNumber(content[i + 1]) || content[i + 1] == '.')) {
            continue;
          } else {
            return false;
          }
        } else if (i - 1 >= 0 && isE(content[i - 1])) {
          if (i + 1 < content.length && isNumber(content[i + 1])) {
            continue;
          } else {
            return false;
          }
        } else {
          return false;
        }
      } else if (content[i] == '.') {
        if (dotCount > 0 || eCount > 0) {
          return false;
        } else {
          dotCount++;
        }
      } else {
        return false;
      }
    }
    return numCount > 0;
  }

  private boolean isNumber(char c) {
    return c >= '0' && c <= '9';
  }

  private boolean isE(char c) {
    return c == 'e' || c == 'E';
  }

}
