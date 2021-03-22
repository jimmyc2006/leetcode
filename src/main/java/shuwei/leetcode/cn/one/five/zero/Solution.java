package shuwei.leetcode.cn.one.five.zero;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

  public int evalRPN(String[] tokens) {
    Deque<Integer> values = new LinkedList<>();
    for (String token : tokens) {
      if ("+".equals(token)) {
        values.addLast(values.pollLast() + values.pollLast());
      } else if ("-".equals(token)) {
        int last = values.pollLast();
        values.addLast(values.pollLast() - last);
      } else if ("*".equals(token)) {
        values.addLast(values.pollLast() * values.pollLast());
      } else if ("/".equals(token)){
        int last = values.pollLast();
        values.addLast(values.pollLast() / last);
      } else {
        values.addLast(Integer.parseInt(token));
      }
    }
    return values.peekLast();
  }
}
