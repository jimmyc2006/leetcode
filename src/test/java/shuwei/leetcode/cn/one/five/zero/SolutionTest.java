package shuwei.leetcode.cn.one.five.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(9, s.evalRPN(new String[]{"2","1","+","3","*"}));
    Assert.assertEquals(6, s.evalRPN(new String[]{"4","13","5","/","+"}));
    Assert.assertEquals(22, s.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
  }
}
