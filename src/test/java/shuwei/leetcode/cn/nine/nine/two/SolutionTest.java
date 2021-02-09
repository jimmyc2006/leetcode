package shuwei.leetcode.cn.nine.nine.two;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(23, s.subarraysWithKDistinct(new int[]{2, 2, 1, 2, 2, 2, 1, 1}, 2));
    Assert.assertEquals(0, s.subarraysWithKDistinct(new int[]{2, 1, 2, 1, 1}, 3));
    Assert.assertEquals(8, s.subarraysWithKDistinct(new int[]{2, 1, 1, 1, 2}, 1));
    Assert.assertEquals(2, s.subarraysWithKDistinct(new int[]{1, 2}, 1));
    Assert.assertEquals(3, s.subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
    Assert.assertEquals(7, s.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
    Assert.assertEquals(8, s.subarraysWithKDistinct(new int[]{1, 1, 1, 3, 4}, 1));
  }

}
