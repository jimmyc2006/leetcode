package shuwei.leetcode.cn.four.five.six;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(false, s.find132pattern(new int[]{-2,1,1}));
    Assert.assertEquals(false, s.find132pattern(new int[]{3}));
    Assert.assertEquals(false, s.find132pattern(new int[]{3, 4}));
    Assert.assertEquals(false, s.find132pattern(new int[]{3, 4, 5}));
    Assert.assertEquals(true, s.find132pattern(new int[]{3, 1, 4, 2}));
    Assert.assertEquals(false, s.find132pattern(new int[]{1, 2, 3, 4}));
    Assert.assertEquals(true, s.find132pattern(new int[]{-1, 3, 2, 0}));
  }
}
