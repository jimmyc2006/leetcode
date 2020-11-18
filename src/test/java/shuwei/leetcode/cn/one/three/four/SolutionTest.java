package shuwei.leetcode.cn.one.three.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(-1, s.canCompleteCircuit(new int[]{3, 3, 4}, new int[]{3, 4, 4}));
    Assert.assertEquals(3, s.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    Assert.assertEquals(-1, s.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
  }
}
