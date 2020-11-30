package shuwei.leetcode.cn.nine.seven.six;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(5, s.largestPerimeter(new int[]{2, 1, 2}));
    Assert.assertEquals(0, s.largestPerimeter(new int[]{1, 2, 1}));
    Assert.assertEquals(10, s.largestPerimeter(new int[]{3, 2, 3, 4}));
    Assert.assertEquals(8, s.largestPerimeter(new int[]{3, 6, 2, 3}));
  }
}
