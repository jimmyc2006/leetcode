package shuwei.leetcode.cn.one.one.zero.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(3, s.countRangeSum(new int[]{0, 0}, 0, 0));
    Assert.assertEquals(3, s.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
  }

}
