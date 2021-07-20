package shuwei.leetcode.cn.two.two.seven;

import java.util.LinkedList;

public class Solution {

  private final char ADD = '+';
  private final char SUB = '-';
  private final char MUL = '*';
  private final char DIV = '/';

  public int calculate(String s) {
    LinkedList<Character> ops = new LinkedList<>();
    LinkedList<Integer> nums = new LinkedList<>();
    s = s.trim();
    int start = 0;
    boolean firstIsNav = false;
    if (s.charAt(0) == '-') {
      start = 1;
      firstIsNav = true;
    }
    int tmp = 0;
    for (int i = start; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
        case ADD:
        case SUB:
          dealADDSUB(ops, c, nums, tmp);
          tmp = 0;
          break;
        case MUL:
        case DIV:
          dealMULDIV(ops, c, nums, tmp);
          tmp = 0;
        case ' ':
          break;
        default:
          tmp = tmp * 10 + c - '0';
          if (firstIsNav) {
            tmp = -tmp;
            firstIsNav = false;
          }
          break;
      }
    }
    if (ops.size() > 0) {
      dealADDSUB(ops, '+', nums, tmp);
    }
    return nums.size() > 0 ? nums.peekLast() : tmp;
  }

  private void dealADDSUB(LinkedList<Character> ops, char thisOp, LinkedList<Integer> nums, int tmp) {
    if (ops.size() == 0) {
      ops.add(thisOp);
      nums.add(tmp);
    } else {
      while (ops.size() > 0) {
        switch (ops.pollLast()) {
          case ADD:
            tmp = nums.pollLast() + tmp;
            break;
          case SUB:
            tmp = nums.pollLast() - tmp;
            break;
          case MUL:
            tmp = nums.pollLast() * tmp;
            break;
          case DIV:
            tmp = nums.pollLast() / tmp;
            break;
          default:
            break;
        }
      }
      ops.add(thisOp);
      nums.add(tmp);
    }
  }

  private void dealMULDIV(LinkedList<Character> ops, char thisOp, LinkedList<Integer> nums, int tmp) {
    if (ops.size() == 0) {
      ops.add(thisOp);
      nums.add(tmp);
    } else {
      switch (ops.peekLast()) {
        case ADD:
        case SUB:
          nums.add(tmp);
          break;
        case MUL:
          ops.pollLast();
          nums.add(nums.pollLast() * tmp);
          break;
        case DIV:
          ops.pollLast();
          nums.add(nums.pollLast() / tmp);
          break;
      }
      ops.add(thisOp);
    }
  }
}
