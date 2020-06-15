package shuwei.leetcode.cn.one.two.seven.six;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertArrayEquals(new Integer[]{1, 6}, s.numOfBurgers(16, 7).toArray(new Integer[2]));
    System.out.print(s.numOfBurgers(4, 17));
  }
}
