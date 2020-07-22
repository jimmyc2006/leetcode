package shuwei.leetcode.cn.three.five;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(2, s.searchInsert(new int[]{1, 3, 5, 6}, 5));
    Assert.assertEquals(1, s.searchInsert(new int[]{1,3,5,6}, 2));
    Assert.assertEquals(4, s.searchInsert(new int[]{1,3,5,6}, 7));
    Assert.assertEquals(0, s.searchInsert(new int[]{1,3,5,6}, 0));
    Assert.assertEquals(0, s.searchInsert(new int[]{1}, 0));
    Assert.assertEquals(1, s.searchInsert(new int[]{1}, 2));
  }

}
