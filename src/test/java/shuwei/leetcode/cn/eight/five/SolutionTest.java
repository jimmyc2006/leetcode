package shuwei.leetcode.cn.eight.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(6, s.maximalRectangle(new char[][]{
            {'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    Assert.assertEquals(0, s.maximalRectangle(new char[][]{{'0'}}));
    Assert.assertEquals(1, s.maximalRectangle(new char[][]{{'1'}}));
    Assert.assertEquals(0, s.maximalRectangle(new char[][]{{'0', '0'}}));
  }
}
