package shuwei.leetcode.cn.three.four.seven;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.topKFrequent(new int[]{1, 2}, 2)));
    System.out.println(Arrays.toString(s.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    System.out.println(Arrays.toString(s.topKFrequent(new int[]{1}, 1)));
  }
}
