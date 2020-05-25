package shuwei.leetcode.cn.one.five.two;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(6, s.maxProduct(new int[]{
            2, 3, -2, 4
    }));
    Assert.assertEquals(0, s.maxProduct(new int[]{-2, 0, -1}));
    Assert.assertEquals(108, s.maxProduct(new int[]
            {-1, -2, -9, -6}));
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    System.out.print(s.maxProduct(new int[]
            {-1, -2, -9, -6}));
  }
}
