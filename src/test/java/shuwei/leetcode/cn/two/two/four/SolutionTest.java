package shuwei.leetcode.cn.two.two.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(-1, s.calculate("(5-(1+(5)))"));
    Assert.assertEquals(3, s.calculate("2-(5-6)"));
    Assert.assertEquals(-1, s.calculate("-2+1"));
    Assert.assertEquals(1, s.calculate("1"));
    Assert.assertEquals(2, s.calculate("1 + 1"));
    Assert.assertEquals(3, s.calculate(" 2-1 + 2 "));
    Assert.assertEquals(23, s.calculate("(1+(4+5+2)-3)+(6+8)"));
  }
}
