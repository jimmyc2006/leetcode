package shuwei.leetcode.cn.one.one.two.two;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertArrayEquals(new int[]{22, 28, 8, 6, 17, 44}, s.relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6}));
//    System.out.println(Arrays.toString(s.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    Assert.assertArrayEquals(new int[]{2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19}, s.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6}));
  }
}
