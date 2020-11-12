package shuwei.leetcode.cn.nine.two.two;

import org.junit.Assert;
import org.junit.Test;

public class Solution1112Test {

  @Test
  public void test() {
    Solution1112 s = new Solution1112();
    Assert.assertArrayEquals(new int[]{4, 5, 2, 7}, s.sortArrayByParityII(new int[]{4, 2, 5, 7}));
    Assert.assertArrayEquals(new int[]{2, 1}, s.sortArrayByParityII(new int[]{1, 2}));
  }
}
