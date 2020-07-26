package shuwei.leetcode.cn.one.four.nine.four;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(3, s.minNumberOfSemesters(4, new int[][]{{2, 1}, {3, 1}, {1, 4}}, 2));
    Assert.assertEquals(4, s.minNumberOfSemesters(5, new int[][]{{2,1},{3,1},{4,1},{1,5}}, 2));
    Assert.assertEquals(6, s.minNumberOfSemesters(11, new int[][]{}, 2));
  }
}
