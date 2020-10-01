package shuwei.leetcode.cn.six.eight.five;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.findRedundantDirectedConnection(new int[][]{
            {4, 2}, {1, 5}, {5, 2}, {5, 3}, {2, 4}
    })));
//    System.out.println(Arrays.toString(s.findRedundantDirectedConnection(new int[][]{
//            {1, 2}, {1, 3}, {2, 3}
//    })));
//    System.out.println(Arrays.toString(s.findRedundantDirectedConnection(new int[][]{
//            {1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}
//    })));
//    System.out.println(Arrays.toString(s.findRedundantDirectedConnection(new int[][]{
//            {2, 1}, {3, 1}, {4, 2}, {1, 4}
//    })));
  }

}
