package shuwei.leetcode.cn.one.eight.nine;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();

    int[] data3 = new int[]{1, 2, 3, 4, 5, 6};
    s.rotate(data3, 3);
    Assert.assertArrayEquals(new int[]{4, 5, 6, 1, 2, 3}, data3);

    data3 = new int[]{1, 2, 3, 4, 5, 6};
    s.rotate(data3, 4);
    Assert.assertArrayEquals(new int[]{3, 4, 5, 6, 1, 2}, data3);

    int[] d = new int[]{1, 2};
    s.rotate(d, 3);
    Assert.assertArrayEquals(new int[]{2, 1}, d);
    int[] data = new int[]{1, 2, 3, 4, 5, 6, 7};
    s.rotate(data, 3);
    Assert.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, data);
    int[] data2 = new int[]{-1,-100,3,99};
    s.rotate(data2, 2);
    Assert.assertArrayEquals(new int[]{3,99,-1,-100}, data2);
  }

}
