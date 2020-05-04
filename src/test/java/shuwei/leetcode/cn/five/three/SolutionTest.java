package shuwei.leetcode.cn.five.three;

import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(6, s.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    System.out.println(s.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
  }
}
