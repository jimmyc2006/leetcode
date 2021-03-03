package shuwei.leetcode.cn.three.three.eight;

import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    int[] ints = s.countBits(100);
    for (int i = 0; i < ints.length; i++) {
      System.out.println(i + "\t" + ints[i]);
    }
  }
}
