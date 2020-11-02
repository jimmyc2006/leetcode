package shuwei.leetcode.cn.three.four.nine;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.intersection(new int[]{1,2,2,1}, new int[]{2,2})));
    System.out.println(Arrays.toString(s.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    System.out.println(Arrays.toString(s.intersection(new int[]{}, new int[]{})));
  }
}
