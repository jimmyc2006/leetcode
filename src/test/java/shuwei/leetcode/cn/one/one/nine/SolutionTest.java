package shuwei.leetcode.cn.one.one.nine;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertArrayEquals(new Integer[]{1, 4,6, 4, 1}, s.getRow(4).toArray(new Integer[1]));
    Assert.assertArrayEquals(new Integer[]{1, 3, 3, 1}, s.getRow(3).toArray(new Integer[1]));
    Assert.assertArrayEquals(new Integer[]{1, 2, 1}, s.getRow(2).toArray(new Integer[1]));
    Assert.assertArrayEquals(new Integer[]{1}, s.getRow(0).toArray(new Integer[1]));
    System.out.println(s.getRow(5));
    System.out.println(s.getRow(6));
    System.out.println(s.getRow(7));
  }
}
