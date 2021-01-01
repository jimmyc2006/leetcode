package shuwei.leetcode.cn.six.zero.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.canPlaceFlowers(new int[]{1}, 0));
    Assert.assertEquals(false, s.canPlaceFlowers(new int[]{1, 0, 1, 0, 1, 0, 1}, 1));
    Assert.assertEquals(true, s.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
    Assert.assertEquals(false, s.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
  }
}
