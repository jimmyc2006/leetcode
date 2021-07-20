package shuwei.leetcode.cn.five.six.nine.one;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(3, s.minOperations(new int[]{6, 6}, new int[]{1}));
    Assert.assertEquals(3, s.minOperations(new int[]{1,2,3,4,5,6}, new int[]{1,1,2,2,2,2}));
    Assert.assertEquals(-1, s.minOperations(new int[]{1,1,1,1,1,1,1}, new int[]{6}));
//    Assert.assertEquals(3, s.minOperations(new int[]{6, 6}, new int[]{1}));
  }
}
