package shuwei.leetcode.cn.four.eight.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(3, s.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    Assert.assertEquals(1, s.findMaxConsecutiveOnes(new int[]{1}));
    Assert.assertEquals(0, s.findMaxConsecutiveOnes(new int[]{0}));
  }
}
