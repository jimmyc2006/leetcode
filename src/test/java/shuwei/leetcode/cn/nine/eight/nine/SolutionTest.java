package shuwei.leetcode.cn.nine.eight.nine;

import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(s.addToArrayForm(new int[]{9,2,7,1,3,4,7,2,6,9,9,1,1,3,1,0,0,9,6,0}, 650));
    System.out.println(s.addToArrayForm(new int[]{1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 7, 5, 6, 6, 4, 4, 0, 0, 6, 3}, 516));
    System.out.println(s.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
            9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9
            , 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
    System.out.println(s.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
    System.out.println(s.addToArrayForm(new int[]{2, 7, 4}, 181));
    System.out.println(s.addToArrayForm(new int[]{2, 1, 5}, 806));
    System.out.println(s.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
  }
}
