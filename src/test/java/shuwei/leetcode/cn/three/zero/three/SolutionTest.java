package shuwei.leetcode.cn.three.zero.three;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
    Assert.assertEquals(1, numArray.sumRange(0, 2));
    Assert.assertEquals(-1, numArray.sumRange(2, 5));
    Assert.assertEquals(-3, numArray.sumRange(0, 5));
  }

  @Test
  public void test2() {
    NumArray numArray = new NumArray(new int[]{-2});
    Assert.assertEquals(-2, numArray.sumRange(0, 0));
  }

  @Test
  public void test3() {
    NumArray numArray = new NumArray(new int[]{});
//    Assert.assertEquals(-2, numArray.sumRange(0, 0));
  }
}
