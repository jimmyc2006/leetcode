package shuwei.leetcode.cn.nine.two.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertTrue(s.isLongPressedName("alex", "aaleex"));
    Assert.assertFalse(s.isLongPressedName("saeed", "ssaaedd"));
    Assert.assertTrue(s.isLongPressedName("leelee", "lleeelee"));
    Assert.assertTrue(s.isLongPressedName("laiden", "laiden"));
  }

}
