package shuwei.leetcode.cn.mst.one.six.one.one;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertArrayEquals(new int[]{3, 4, 5, 6}, s.divingBoard(1, 2, 3));
    Assert.assertArrayEquals(new int[]{6}, s.divingBoard(2, 2, 3));
    Assert.assertArrayEquals(new int[]{0}, s.divingBoard(2, 2, 0));
  }
}
