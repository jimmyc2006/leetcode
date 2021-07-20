package shuwei.leetcode.cn.one.zero.zero.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(10, s.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    Assert.assertEquals(6, s.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    Assert.assertEquals(1, s.longestOnes(new int[]{0}, 1));
    Assert.assertEquals(1, s.longestOnes(new int[]{1}, 1));
    Assert.assertEquals(1, s.longestOnes(new int[]{1, 0 , 1}, 0));
    Assert.assertEquals(5, s.longestOnes(new int[]{1, 0 , 0, 0, 1}, 5));
  }
}
