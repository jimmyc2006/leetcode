package shuwei.leetcode.cn.five.five.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    System.out.println(s.reverseWords("sa"));
    Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", s.reverseWords("Let's take LeetCode contest"));
  }
}
