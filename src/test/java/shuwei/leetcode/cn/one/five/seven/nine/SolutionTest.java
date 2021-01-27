package shuwei.leetcode.cn.one.five.seven.nine;

import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(2, s.maxNumEdgesToRemove(4, new int[][]{{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}}));
    Assert.assertEquals(0, s.maxNumEdgesToRemove(4, new int[][]{{3, 1, 2}, {3, 2, 3}, {1, 1, 4}, {2, 1, 4}}));
    Assert.assertEquals(-1, s.maxNumEdgesToRemove(4, new int[][]{{3, 2, 3}, {1, 1, 2}, {2, 3, 4}}));
    Assert.assertEquals(0, s.maxNumEdgesToRemove(2, new int[][]{{3, 1, 2}}));
  }
}
