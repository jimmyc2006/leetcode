package shuwei.leetcode.cn.eight.three.nine;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(2, s.numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
    Assert.assertEquals(1, s.numSimilarGroups(new String[]{"omv", "ovm"}));
    Assert.assertEquals(1, s.numSimilarGroups(new String[]{"omvovm"}));
  }
}
