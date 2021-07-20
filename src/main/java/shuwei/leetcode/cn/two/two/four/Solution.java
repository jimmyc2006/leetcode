package shuwei.leetcode.cn.two.two.four;

public class Solution {

  /**
   * 遇到配对的括号以后，就降级
   * @param s
   * @return
   */
  public int calculate(String s) {
    return calStr(s.replace(" ", ""));
  }

  // 一次只解决一个括号
  private int calStr(String s) {
    if (!s.contains("(")) {
      return cal(s);
    }
    int lastLeft = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        lastLeft = i;
      } else if (ch == ')') {
        int res = cal(s.substring(lastLeft + 1, i));
        if (lastLeft == 0) {
          if (i + 1 < s.length()) {
            return calStr(Integer.toString(res) + s.substring(i + 1));
          } else {
            return res;
          }
        }
        if (res < 0) {
          if(s.charAt(lastLeft - 1) == '-') {
            if (i + 1 < s.length()) {
              return calStr(s.subSequence(0, lastLeft - 1) + "+" + (-res) + s.substring(i + 1));
            } else {
              return calStr(s.subSequence(0, lastLeft - 1) + "+" + (-res));
            }
          } else {
            if (i + 1 < s.length()) {
              return calStr(s.subSequence(0, lastLeft - 1) + Integer.toString(res) + s.substring(i + 1));
            } else {
              return calStr(s.subSequence(0, lastLeft - 1) + Integer.toString(res));
            }
          }
        } else {
          if (i + 1 < s.length()) {
            return calStr(s.subSequence(0, lastLeft) +  Integer.toString(res) + s.substring(i + 1));
          } else {
            return calStr(s.subSequence(0, lastLeft) +  Integer.toString(res));
          }
        }
      }
    }
    return 0;
  }

  // 计算不带括号的算式
  private int cal(String s) {
    int left = 1;
    if (s.charAt(0) == '-') {
      s = s.substring(1);
      left = -1;
    }
    String[] split = s.split("[+-]");
    left = left * Integer.parseInt(split[0]);
    if (split.length == 1) {
      return left;
    }
    int rightIndex = 1;
    for (int i = 0; i < s.length(); i++) {
      char op = s.charAt(i);
      if (op == '+') {
        left = left + Integer.parseInt(split[rightIndex++]);
      } else if (op == '-') {
        if (i == 0) {
          left = -1 * Integer.parseInt(split[rightIndex++]);
        } else {
          left = left - Integer.parseInt(split[rightIndex++]);
        }
      }
    }
    return left;
  }

}
