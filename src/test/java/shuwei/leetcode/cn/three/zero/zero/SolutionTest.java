package shuwei.leetcode.cn.three.zero.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(4, s.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    Assert.assertEquals(4, s.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    Assert.assertEquals(1, s.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
  }
}
