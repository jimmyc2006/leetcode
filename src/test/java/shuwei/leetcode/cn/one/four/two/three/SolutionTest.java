package shuwei.leetcode.cn.one.four.two.three;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(12, s.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    Assert.assertEquals(4, s.maxScore(new int[]{2, 2, 2}, 2));
    Assert.assertEquals(55, s.maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
    Assert.assertEquals(1, s.maxScore(new int[]{1, 1000, 1}, 1));
    Assert.assertEquals(202, s.maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
    Assert.assertEquals(1, s.maxScore(new int[]{1}, 1));
  }
}
