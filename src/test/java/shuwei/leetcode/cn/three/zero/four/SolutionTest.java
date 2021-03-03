package shuwei.leetcode.cn.three.zero.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    NumMatrix s = new NumMatrix(new int[][]{
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
    });
    Assert.assertEquals(8, s.sumRegion(2, 1, 4, 3));
    Assert.assertEquals(11, s.sumRegion(1, 1, 2, 2));
    Assert.assertEquals(12, s.sumRegion(1, 2, 2, 4));
  }

  @Test
  public void test2() {
    NumMatrix s = new NumMatrix(new int[][]{});
//    Assert.assertEquals(8, s.sumRegion(2, 1, 4, 3));
//    Assert.assertEquals(11, s.sumRegion(1, 1, 2, 2));
//    Assert.assertEquals(12, s.sumRegion(1, 2, 2, 4));
  }
}
