package shuwei.leetcode.cn.six.seven.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(3, s.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    Assert.assertEquals(1, s.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
    Assert.assertEquals(3, s.findLengthOfLCIS(new int[]{2, 2, 2, 4, 5}));
    Assert.assertEquals(0, s.findLengthOfLCIS(new int[]{}));
    Assert.assertEquals(1, s.findLengthOfLCIS(new int[]{2}));
  }
}
