package shuwei.leetcode.cn.four.eight.six;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.PredictTheWinner(new int[]{0}));
    Assert.assertEquals(true, s.PredictTheWinner(new int[]{1}));
    Assert.assertEquals(false, s.PredictTheWinner(new int[]{1, 5, 2}));
    Assert.assertEquals(true, s.PredictTheWinner(new int[]{1, 5, 233, 7}));
  }

}
