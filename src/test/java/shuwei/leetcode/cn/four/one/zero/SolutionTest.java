package shuwei.leetcode.cn.four.one.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(18, s.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
  }

}
