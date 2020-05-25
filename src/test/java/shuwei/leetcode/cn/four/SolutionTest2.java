package shuwei.leetcode.cn.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest2 {
  @Test
  public void test() {
    Solution2 s = new Solution2();
    Assert.assertEquals(2.0, s.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 0.001);
    System.out.println("1");
    Assert.assertEquals(2.5, s.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 0.001);
    System.out.println("2");
    Assert.assertEquals(1.0, s.findMedianSortedArrays(new int[0], new int[]{1}), 0.001);
    System.out.println("3");
    Assert.assertEquals(2.5, s.findMedianSortedArrays(new int[0], new int[]{2, 3}), 0.001);
    System.out.println("4");
    Assert.assertEquals(2.0, s.findMedianSortedArrays(new int[]{2, 2, 2, 2}, new int[]{2, 2, 2}), 0.001);
    System.out.println("5");
    Assert.assertEquals(2.0, s.findMedianSortedArrays(new int[]{2, 2, 2}, new int[]{2, 2, 2, 2}), 0.001);
    System.out.println("6");
    Assert.assertEquals(2.0, s.findMedianSortedArrays(new int[]{1, 1, 3, 3}, new int[]{1, 1, 3, 3}), 0.001);
    System.out.println("7");
    Assert.assertEquals(2.0, s.findMedianSortedArrays(new int[]{1}, new int[]{2, 3}), 0.001);
    System.out.println("8");
    Assert.assertEquals(3.0, s.findMedianSortedArrays(new int[]{2}, new int[]{1, 3, 4, 5}), 0.001);
    System.out.println("9");
    Assert.assertEquals(3.5, s.findMedianSortedArrays(new int[]{1, 5}, new int[]{2, 3, 4, 6}), 0.001);
    System.out.println("10");
    Assert.assertEquals(4.5, s.findMedianSortedArrays(new int[]{1, 4}, new int[]{2, 3, 5, 6, 7, 8}), 0.001);
    System.out.println("11");
    Assert.assertEquals(5, s.findMedianSortedArrays(new int[]{7, 8}, new int[]{1, 2, 3, 4, 5, 6, 9}), 0.001);
    System.out.println("12");
    Assert.assertEquals(1.5, s.findMedianSortedArrays(new int[]{1, 2}, new int[]{-1, 3}), 0.001);
    System.out.println("13");
    Assert.assertEquals(4.5, s.findMedianSortedArrays(new int[]{2, 3}, new int[]{1, 4, 5, 6, 7, 8}), 0.001);
    System.out.println("14");
    Assert.assertEquals(4.5, s.findMedianSortedArrays(new int[]{1, 4, 5, 6, 7, 8}, new int[]{2, 3}), 0.001);
    System.out.println("15");
    Assert.assertEquals(5.0, s.findMedianSortedArrays(new int[]{1, 2, 3, 4, 5, 6, 9}, new int[]{7, 8}), 0.001);
  }

  @Test
  public void test2() {
    Solution2 s = new Solution2();
    System.out.print(s.findMedianSortedArrays(new int[]{1}, new int[]{1}));
  }
}
