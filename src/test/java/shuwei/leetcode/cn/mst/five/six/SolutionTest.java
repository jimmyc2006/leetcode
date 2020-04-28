package shuwei.leetcode.cn.mst.five.six;

import java.util.Arrays;

import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.singleNumbers(new int[] { 4, 1, 4, 6 })));
    System.out.println(Arrays.toString(s.singleNumbers(new int[] { 1, 2, 10, 4, 1, 4, 3, 3 })));
  }
}
