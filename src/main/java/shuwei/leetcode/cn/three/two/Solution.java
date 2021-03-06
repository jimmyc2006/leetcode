package shuwei.leetcode.cn.three.two;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

  // dp解法, 1ms, 100%
  public int longestValidParentheses(String s) {
    if (s == null || s.length() <= 1) {
      return 0;
    }
    int ans = 0;
    int length = s.length();
    char[] sChars = s.toCharArray();
    int[] f = new int[length + 1];
    for (int i = 1; i <= length; i++) {
      if (sChars[i - 1] == '(') {
        f[i] = 0;
      } else {
        if (f[i - 1] == 0) {
          int index = i - 2;
          if (index >= 0 && sChars[index] == '(') {
            f[i] = 2 + f[i - 2];
            ans = Math.max(ans, f[i]);
          } else {
            f[i] = 0;
          }
        } else {
          int index = i - f[i - 1] - 2;
          if (index >= 0 && sChars[index] == '(') {
            f[i] = 2 + f[i - 1] + f[index];
            ans = Math.max(ans, f[i]);
          } else {
            f[i] = 0;
          }
        }
      }
    }
    return ans;
  }

  // 栈解法
  public int longestValidParentheses1(String s) {
    if (s == null || s.length() <= 1) {
      return 0;
    }
    int ans = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(-1);
    char[] chars = s.toCharArray();
    int length = chars.length;
    for (int i = 0; i < length; i++) {
      if (')' == chars[i]) {
        if (stack.size() > 1) {
          int lastIndex = stack.peek();
          if (chars[lastIndex] == '(') {
            stack.poll();
            ans = Math.max(ans, i - stack.peek());
          } else {
            stack.push(i);
          }
        } else {
          stack.push(i);
        }
      } else {
        stack.push(i);
      }
    }
    return ans;
  }
}
