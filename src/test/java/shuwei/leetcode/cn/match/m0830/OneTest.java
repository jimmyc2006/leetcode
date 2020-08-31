package shuwei.leetcode.cn.match.m0830;

import org.junit.Assert;
import org.junit.Test;

public class OneTest {
  @Test
  public void test() {
    One s = new One();
    Assert.assertEquals(true, s.containsPattern(new int[]{2, 2}, 1, 2));
    Assert.assertEquals(true, s.containsPattern(new int[]{1}, 1, 1));
    Assert.assertEquals(true, s.containsPattern(new int[]{1, 2, 4, 4, 4, 4}, 1, 3));
    Assert.assertEquals(true, s.containsPattern(new int[]{1,2,1,2,1,1,1,3}, 2, 2));
    Assert.assertEquals(false, s.containsPattern(new int[]{1,2,1,2,1,3}, 2, 3));
    Assert.assertEquals(false, s.containsPattern(new int[]{1,2,3,1,2}, 2, 2));
    Assert.assertEquals(false, s.containsPattern(new int[]{2,2,2,2}, 2, 3));
  }
}
