package shuwei.leetcode.cn.one.three.zero.zero;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(3, s.findBestValue(new int[]{4,9,3}, 10));
    Assert.assertEquals(5, s.findBestValue(new int[]{2,3,5}, 10));
    Assert.assertEquals(11361, s.findBestValue(new int[]{60864,25176,27249,21296,20204}, 56803));
    Assert.assertEquals(17422, s.findBestValue(new int[]{1547,83230,57084,93444,70879}, 71237));
    Assert.assertEquals(5, s.findBestValue(new int[]{2,3,5}, 11));
    Assert.assertEquals(8463, s.findBestValue(new int[]{40091, 2502, 74024, 53101, 60555, 33732, 23467, 40560, 32693, 13013}, 78666));
  }
}
