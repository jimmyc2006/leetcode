package shuwei.leetcode.cn.three.two;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public int longestValidParentheses(String s) {
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
