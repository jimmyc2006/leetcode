package shuwei.leetcode.cn.six.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals("213", s.getPermutation(3, 3));
    System.out.println("1");
    Assert.assertEquals("1", s.getPermutation(1, 1));
    System.out.println("2");
    Assert.assertEquals("2314", s.getPermutation(4, 9));
    System.out.println("3");
  }
}
