package shuwei.leetcode.cn.one.zero.nine.five;

import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {
  
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(2, s.findInMountainArray(3, new Ma(new int[]{1, 2, 3, 5, 3})));
    Assert.assertEquals(2, s.findInMountainArray(3, new Ma(new int[] {1,2,3,4,5,3,1})));
    Assert.assertEquals(-1, s.findInMountainArray(3, new Ma(new int[]{0,1,2,4,2,1})));
  }
}

class Ma implements MountainArray {
  int[] arr;
  
  public Ma(int[] arr) {
    super();
    this.arr = arr;
  }

  @Override
  public int get(int index) {
    return arr[index];
  }

  @Override
  public int length() {
    return arr.length;
  }
  
}