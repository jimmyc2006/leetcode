package shuwei.leetcode.cn.three.one;

import org.junit.Assert;
import org.junit.Test;

public class Solution1110Test {
  @Test
  public void test() {
    Solution1110 s = new Solution1110();
    int[] data1 = new int[]{1, 2, 3};
    s.nextPermutation(data1);
    Assert.assertArrayEquals(new int[]{1, 3, 2}, data1);
    int[] data2 = new int[]{3, 2, 1};
    s.nextPermutation(data2);
    Assert.assertArrayEquals(new int[]{1, 2, 3}, data2);
    int[] data3 = new int[]{1, 1, 5};
    s.nextPermutation(data3);
    Assert.assertArrayEquals(new int[]{1, 5, 1}, data3);
  }

  @Test
  public void test2() {
    Solution1110 s = new Solution1110();
    int[] data1 = new int[]{1, 3, 2};
    s.nextPermutation(data1);
    Assert.assertArrayEquals(new int[]{2, 1, 3}, data1);
  }

  @Test
  public void test3() {
    Solution1110 s = new Solution1110();
    int[] data1 = new int[]{3, 5, 4, 2, 1};
    s.nextPermutation(data1);
    Assert.assertArrayEquals(new int[]{4, 1, 2, 3, 5}, data1);
  }
}
