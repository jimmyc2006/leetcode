package shuwei.leetcode.cn.three.zero.three;

public class NumArray {

  private int[] sums;

  public NumArray(int[] nums) {
    sums = new int[nums.length];
    int currSum = 0;
    for (int i = 0; i < nums.length; i++) {
      currSum += nums[i];
      sums[i] = currSum;
    }
  }

  public int sumRange(int i, int j) {
    if(i == 0) {
      return sums[j];
    } else {
      return sums[j] - sums[i - 1];
    }
  }

}
