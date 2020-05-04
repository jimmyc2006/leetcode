package shuwei.leetcode.cn.three;

import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
    Assert.assertEquals(1, s.lengthOfLongestSubstring("bbbbb"));
    Assert.assertEquals(3, s.lengthOfLongestSubstring("pwwkew"));
    Assert.assertEquals(2, s.lengthOfLongestSubstring("abba"));
    
  }
}
