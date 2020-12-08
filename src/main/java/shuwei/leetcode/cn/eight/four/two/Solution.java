package shuwei.leetcode.cn.eight.four.two;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  /**
   * 从第一个数值开始尝试，是否a1 + a2 = a3,如果遇到满足条件的就开始判断
   * @param S
   * @return
   */
  public List<Integer> splitIntoFibonacci(String S) {
    ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder(S);
    int length = S.length();
    if (sb.charAt(0) == '0') {
      for (int j = 2; j < sb.length(); j++) {
        if (Long.parseLong(sb.substring(1, j)) > Integer.MAX_VALUE) {
          return ans;
        }
        int next = Integer.parseInt(sb.substring(0, 1)) + Integer.parseInt(sb.substring(1, j));
        if (findNum(sb, j, next) > 0 && isGood(1, j, sb)) {
          return ans;
        }
      }
      return ans;
    }
    for (int i = 1 ; i < length - 1; i++) {
      if (Long.parseLong(sb.substring(0, i)) > Integer.MAX_VALUE) {
        return ans;
      }
      for (int j = i + 1; j < sb.length(); j++) {
        if (Long.parseLong(sb.substring(i, j)) > Integer.MAX_VALUE) {
          break;
        }
        if (sb.charAt(i) == '0') {
          if(isGood(i, i + 1, sb)) {
            return ans;
          } else {
            break;
          }
        }
        long next = Long.parseLong(sb.substring(0, i)) + Integer.parseInt(sb.substring(i, j));
        if (next > Integer.MAX_VALUE) {
          break;
        }
        if (findNum(sb, j, next) > 0 && isGood(i, j, sb)) {
          return ans;
        }
      }
    }
    return ans;
  }

  private List<Integer> ans;
  private boolean isGood(int start2, int end2, StringBuilder sb) {
    ans.add(Integer.parseInt(sb.substring(0, start2)));
    ans.add(Integer.parseInt(sb.substring(start2, end2)));
    int index = end2;
    int length = sb.length();
    while (index < length) {
      long next = ans.get(ans.size() - 1) + ans.get(ans.size() - 2);
      if (next > Integer.MAX_VALUE) {
        ans.clear();
        return false;
      }
      int nextIndex = findNum(sb, index, next);
      if (nextIndex == - 1) {
        ans.clear();
        return false;
      } else {
        ans.add((int)next);
        index = nextIndex;
      }
    }
    return true;
  }

  private int findNum(StringBuilder sb, int start, long num) {
    if (num > 0 && sb.charAt(start) == '0') {
      return -1;
    }
    for (int i = start + 1; i <= sb.length(); i++) {
      if (Long.parseLong(sb.substring(start, i)) > Integer.MAX_VALUE) {
        return -1;
      }
      int n = Integer.parseInt(sb.substring(start, i));
      if (n == num) {
        return i;
      } else if (n > num) {
        return -1;
      }
    }
    return -1;
  }

}
