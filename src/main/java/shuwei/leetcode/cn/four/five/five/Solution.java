package shuwei.leetcode.cn.four.five.five;

import java.util.Arrays;

public class Solution {
  /**
   * 先对小孩胃口和饼干排序
   * 然后从前往后遍历
   * 如果小孩的胃口小于饼干，就直接给
   * 如果消耗的胃口大于饼干，就将饼干往后移动，直到小孩或者饼干没有了
   * @param g
   * @param s
   * @return
   */
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int indexG =0, indexS = 0;
    while (indexG < g.length && indexS < s.length) {
      if (g[indexG] <= s[indexS]) {
        indexG++;
      }
      indexS++;
    }
    return indexG;
  }
}
