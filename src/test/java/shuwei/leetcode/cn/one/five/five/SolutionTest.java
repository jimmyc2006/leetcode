package shuwei.leetcode.cn.one.five.five;

import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {
  @Test
  public void test() {
    MinStack ms = new MinStack();
    ms.push(-2);
    ms.push(0);
    ms.push(-3);
    Assert.assertEquals(-3, ms.getMin());
    ms.pop();
    Assert.assertEquals(0, ms.top());
    Assert.assertEquals(-2, ms.getMin());
  }
}
