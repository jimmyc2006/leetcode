package shuwei.leetcode.cn.bs1;


import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(2500, s.average(new int[]{4000,3000,1000,2000}), 0.001);
    Assert.assertEquals(2000, s.average(new int[]{3000,1000,2000}), 0.001);
    Assert.assertEquals(3500, s.average(new int[]{6000,5000,4000,3000,2000,1000}), 0.001);
    Assert.assertEquals(4750, s.average(new int[]{8000,9000,2000,3000,6000,1000}), 0.001);
  }
}
