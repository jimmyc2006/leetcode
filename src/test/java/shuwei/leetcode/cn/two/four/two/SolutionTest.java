package shuwei.leetcode.cn.two.four.two;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true,s.isAnagram("anagram", "nagaram"));
    Assert.assertFalse(s.isAnagram("rat", "car"));
  }
}
