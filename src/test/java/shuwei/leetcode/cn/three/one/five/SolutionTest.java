package shuwei.leetcode.cn.three.one.five;

import org.junit.Test;


public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(s.countSmaller(new int[]{1, 0, 2}));
    System.out.println(s.countSmaller(new int[]{-1, -2}));
    System.out.println(s.countSmaller(new int[]{5, 2, 6, 1}));
    System.out.print(s.countSmaller(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41}));
  }

}
