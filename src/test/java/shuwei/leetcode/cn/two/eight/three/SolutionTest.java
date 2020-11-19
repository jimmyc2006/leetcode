package shuwei.leetcode.cn.two.eight.three;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    int[] arr = {0,1,0,3,12};
    s.moveZeroes(arr);
    System.out.println(Arrays.toString(arr));
    Assert.assertArrayEquals(new int[]{1,3,12,0,0}, arr);
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    int[] arr = {0,1};
    s.moveZeroes(arr);
    System.out.println(Arrays.toString(arr));
    Assert.assertArrayEquals(new int[]{1,0}, arr);
  }
}
