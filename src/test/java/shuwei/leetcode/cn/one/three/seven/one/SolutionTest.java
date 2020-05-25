package shuwei.leetcode.cn.one.three.seven.one;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(13, s.findTheLongestSubstring("eleetminicoworoep"));
    Assert.assertEquals(5, s.findTheLongestSubstring("leetcodeisgreat"));
    Assert.assertEquals(6, s.findTheLongestSubstring("bcbcbc"));
  }
}
