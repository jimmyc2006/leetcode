package shuwei.leetcode.cn.two.eight.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(2, s.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    Assert.assertEquals(3, s.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    Assert.assertEquals(2, s.findDuplicate(new int[]{1, 2, 2}));
    Assert.assertEquals(1, s.findDuplicate(new int[]{1, 1}));
    Assert.assertEquals(1, s.findDuplicate(new int[]{1, 1, 2}));
  }
}
