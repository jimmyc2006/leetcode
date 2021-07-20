package shuwei.leetcode.cn.two.two.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(1, s.calculate(" 1 "));
    Assert.assertEquals(-24, s.calculate("1*2-3/4+5*6-7*8+9/10"));
    Assert.assertEquals(7, s.calculate("3+2*2"));
    Assert.assertEquals(1, s.calculate("3/2"));
    Assert.assertEquals(5, s.calculate(" 3+5 / 2 "));
  }
}
