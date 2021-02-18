package shuwei.leetcode.cn.nine.nine.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(3, s.minKBitFlips(new int[]{0,0,0,1,0,1,1,0}, 3));
    Assert.assertEquals(2, s.minKBitFlips(new int[]{0, 1, 0}, 1));
    Assert.assertEquals(-1, s.minKBitFlips(new int[]{1, 1, 0}, 2));
  }
}
