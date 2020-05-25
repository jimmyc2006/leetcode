package shuwei.leetcode.cn.five.six.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(2, s.subarraySum(new int[]{1, 1, 1}, 2));
    Assert.assertEquals(0, s.subarraySum(new int[]{1}, 0));
    Assert.assertEquals(1, s.subarraySum(new int[]{-1, -1, 1}, 0));
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    int result = s.subarraySum(new int[]{1, 2, 3}, 3);
    Assert.assertEquals(2, result);
  }
}
