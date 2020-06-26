package shuwei.leetcode.cn.jz.five.three;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(0, s.missingNumber(new int[]{1, 2}));
    Assert.assertEquals(2, s.missingNumber(new int[]{0,1,3}));
    Assert.assertEquals(8, s.missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
    Assert.assertEquals(1, s.missingNumber(new int[]{0,2}));
    Assert.assertEquals(0, s.missingNumber(new int[]{1}));
    Assert.assertEquals(1, s.missingNumber(new int[]{0}));
  }
}
