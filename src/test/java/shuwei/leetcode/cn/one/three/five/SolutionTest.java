package shuwei.leetcode.cn.one.three.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(6, s.candy(new int[]{5, 3, 7, 3}));
    Assert.assertEquals(7, s.candy(new int[]{1, 3, 2, 2, 1}));
    Assert.assertEquals(18, s.candy(new int[]{1, 6, 10, 8, 7, 3, 2}));
    Assert.assertEquals(4, s.candy(new int[]{1, 2, 2}));
    Assert.assertEquals(5, s.candy(new int[]{1, 0, 2}));
    Assert.assertEquals(11, s.candy(new int[]{1, 3, 4, 5, 2}));
  }
}
