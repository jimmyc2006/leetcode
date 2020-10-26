package shuwei.shuwei.leetcode.cn.one.three.six.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertArrayEquals(new int[]{4,0,1,1,3}, s.smallerNumbersThanCurrent(new int[]{8,1,2,2,3}));
    Assert.assertArrayEquals(new int[]{2,1,0,3}, s.smallerNumbersThanCurrent(new int[]{6,5,4,8}));
    Assert.assertArrayEquals(new int[]{0,0,0,0}, s.smallerNumbersThanCurrent(new int[]{7,7,7,7}));
  }
}
