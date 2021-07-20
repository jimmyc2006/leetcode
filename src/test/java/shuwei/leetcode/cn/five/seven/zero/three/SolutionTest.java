package shuwei.leetcode.cn.five.seven.zero.three;

import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(s.maxAverageRatio(new int[][]{{2,4},{3,9},{4,5},{2,10}}, 4));
    System.out.println(s.maxAverageRatio(new int[][]{{1,2},{3,5},{2,2}}, 2));
  }
}
