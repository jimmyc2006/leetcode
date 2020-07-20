package shuwei.leetcode.cn.one.six.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertArrayEquals(new int[]{1, 2}, s.twoSum(new int[]{2, 7, 11, 15}, 9));
  }
}
