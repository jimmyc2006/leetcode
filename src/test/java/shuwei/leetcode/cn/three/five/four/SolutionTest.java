package shuwei.leetcode.cn.three.five.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(3, s.maxEnvelopes(new int[][]{{1, 3}, {3, 5}, {6, 7}, {6, 8}, {8, 4}, {9, 5}}));
    Assert.assertEquals(3, s.maxEnvelopes(new int[][]{{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}}));
    Assert.assertEquals(3, s.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    Assert.assertEquals(1, s.maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 1}}));
    Assert.assertEquals(2, s.maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {2, 2}}));
    Assert.assertEquals(1, s.maxEnvelopes(new int[][]{{1, 1}}));
  }
}
