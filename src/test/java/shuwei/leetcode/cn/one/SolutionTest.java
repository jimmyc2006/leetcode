package shuwei.leetcode.cn.one;

import org.junit.Assert;
import org.junit.Test;

import shuwei.leetcode.cn.review.four.four.five.one.OneSolution;

public class SolutionTest {
  @Test
  public void test() {
    OneSolution s = new OneSolution();
    Assert.assertArrayEquals(new int[]{0, 1}, s.twoSum(new int[]{2, 7, 11,15}, 9));
  }
}
