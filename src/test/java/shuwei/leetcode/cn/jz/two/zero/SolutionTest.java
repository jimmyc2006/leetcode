package shuwei.leetcode.cn.jz.two.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(false, s.isNumber(".e1"));
    Assert.assertEquals(true, s.isNumber("+100"));
    Assert.assertEquals(true, s.isNumber("5e2"));
    Assert.assertEquals(true, s.isNumber("-123"));
    Assert.assertEquals(true, s.isNumber("3.1416"));
    Assert.assertEquals(true, s.isNumber("-1E-16"));
    Assert.assertEquals(true, s.isNumber("0123"));
    Assert.assertEquals(true, s.isNumber("1 "));
    Assert.assertEquals(true, s.isNumber(".1 "));
    Assert.assertEquals(true, s.isNumber("1. "));
    Assert.assertEquals(true, s.isNumber("+.8"));
    Assert.assertEquals(true, s.isNumber("+8."));
    Assert.assertEquals(true, s.isNumber("46.e3"));

    Assert.assertEquals(false, s.isNumber("12e"));
    Assert.assertEquals(false, s.isNumber("1a3.14"));
    Assert.assertEquals(false, s.isNumber("1.2.3"));
    Assert.assertEquals(false, s.isNumber("+-5"));
    Assert.assertEquals(false, s.isNumber("12e+5.4"));

  }

}
