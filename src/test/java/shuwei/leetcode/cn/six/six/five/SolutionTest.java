package shuwei.leetcode.cn.six.six.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test () {
    Solution s = new Solution();
    Assert.assertEquals(true, s.checkPossibility(new int[]{4, 2, 3}));
    Assert.assertEquals(false, s.checkPossibility(new int[]{4, 2, 1}));
  }
}
