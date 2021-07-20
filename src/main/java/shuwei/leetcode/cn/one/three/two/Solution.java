package shuwei.leetcode.cn.one.three.two;

import java.util.Arrays;

public class Solution {

  /**
   * 最小分割次数，也就是尽可能长的分割
   * @param s
   * @return
   */
  public int minCut(String s) {
    int length = s.length();
    boolean[][] isHuiwen = new boolean[length][length];
    for (int i = 0; i < isHuiwen.length; i++) {
      Arrays.fill(isHuiwen[i], true);
    }
    for (int i = 1; i < length; i++) {
      for (int j = 0; j < i; j++) {
        isHuiwen[j][i] = (s.charAt(j) == s.charAt(i) && isHuiwen[j + 1][i - 1]);
      }
    }
    int[] f = new int[length];
    Arrays.fill(f, Integer.MAX_VALUE);
    for (int i = 0; i < length; i++) {
      if (isHuiwen[0][i]) {
        f[i] = 0;
      } else {
        for (int j = 0; j < i; j++) {
          if(isHuiwen[j + 1][i]) {
            f[i] = Math.min(f[i], f[j] + 1);
          }
        }
      }
    }
    return f[length - 1];
//    return deal(s, 0, length - 1);
  }

  // 这个方法超时
//  private int deal(String s, int start, int end) {
//    if (isHuiwen[start][end]) {
//      return 0;
//    }
//    int min = Integer.MAX_VALUE;
//    for (int i = end - 1; i >= start; i--) {
//      min = Math.min(min, 1 + deal(s, start, i) + deal(s, i + 1, end));
//    }
//    return min;
//  }
}
