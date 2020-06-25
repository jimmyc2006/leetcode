package shuwei.leetcode.cn.one.three.nine;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.wordBreak("leetcode", Arrays.asList("leet", "code")));
    Assert.assertEquals(true, s.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    Assert.assertEquals(false, s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
  }
}
