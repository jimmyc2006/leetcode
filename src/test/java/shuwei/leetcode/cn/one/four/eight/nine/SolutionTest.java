package shuwei.leetcode.cn.one.four.eight.nine;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    List<List<Integer>> criticalAndPseudoCriticalEdges =
            s.findCriticalAndPseudoCriticalEdges(5, new int[][]{{0, 1, 1}, {1, 2, 1}, {2, 3, 2}, {0, 3, 2}, {0, 4, 3}, {3, 4, 3}, {1, 4, 6}});
    System.out.println(criticalAndPseudoCriticalEdges.get(0));
    System.out.println(criticalAndPseudoCriticalEdges.get(1));
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    List<List<Integer>> criticalAndPseudoCriticalEdges =
            s.findCriticalAndPseudoCriticalEdges(4, new int[][]{{0, 1, 1}, {1, 2, 1}, {2, 3, 1}, {0, 3, 1}});
    System.out.println(criticalAndPseudoCriticalEdges.get(0));
    System.out.println(criticalAndPseudoCriticalEdges.get(1));
  }
}
