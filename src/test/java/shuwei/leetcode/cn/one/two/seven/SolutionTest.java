package shuwei.leetcode.cn.one.two.seven;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(5, s.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    Assert.assertEquals(0, s.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
  }
}
