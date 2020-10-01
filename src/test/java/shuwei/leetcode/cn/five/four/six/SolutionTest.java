package shuwei.leetcode.cn.five.four.six;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(23, s.removeBoxes(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}));
  }
}
