package shuwei.leetcode.cn.match.m0830;

import org.junit.Assert;
import org.junit.Test;

public class TwoTest {

  @Test
  public void test() {
    Two t = new Two();
    Assert.assertEquals(1, t.getMaxLen(new int[]{1}));
    Assert.assertEquals(0, t.getMaxLen(new int[]{-1}));
    Assert.assertEquals(4, t.getMaxLen(new int[]{1, -2, -3, 4}));
    Assert.assertEquals(3, t.getMaxLen(new int[]{0,1,-2,-3,-4}));
    Assert.assertEquals(2, t.getMaxLen(new int[]{-1,-2,-3,0,1}));
    Assert.assertEquals(1, t.getMaxLen(new int[]{-1,2}));
    Assert.assertEquals(4, t.getMaxLen(new int[]{1,2,3,5,-6,4,0,10}));
  }

}
