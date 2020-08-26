package shuwei.leetcode.cn.six.seven.nine;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.judgePoint24(new int[]{3, 3, 8, 8}));
    Assert.assertEquals(true, s.judgePoint24(new int[]{1, 3, 4, 6}));
    Assert.assertEquals(true, s.judgePoint24(new int[]{4, 1, 8, 7}));
    Assert.assertEquals(false, s.judgePoint24(new int[]{1, 2, 1, 2}));
  }

}
