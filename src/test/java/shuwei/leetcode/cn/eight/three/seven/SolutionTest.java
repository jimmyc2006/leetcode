package shuwei.leetcode.cn.eight.three.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(1.0, s.new21Game(10, 1, 10), 0.00001);
    Assert.assertEquals(0.6, s.new21Game(6, 1, 10), 0.00001);
    Assert.assertEquals(0.73278, s.new21Game(21, 17, 10), 0.00001);
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    Assert.assertEquals(0.73278, s.new21Game(21, 17, 10), 0.00001);
  }
}
