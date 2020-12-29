package shuwei.leetcode.cn.three.three.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(28, s.minPatches(new int[]{1, 2, 31, 33}, 2147483647));
    Assert.assertEquals(3, s.minPatches(new int[]{}, 7));
    Assert.assertEquals(0, s.minPatches(new int[]{1, 2, 2}, 5));
    Assert.assertEquals(2, s.minPatches(new int[]{1, 5, 10}, 20));
    Assert.assertEquals(1, s.minPatches(new int[]{1, 3}, 6));
    Assert.assertEquals(1, s.minPatches(new int[]{3}, 1));
    Assert.assertEquals(0, s.minPatches(new int[]{1}, 1));
  }
}
