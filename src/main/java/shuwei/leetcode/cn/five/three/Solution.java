package shuwei.leetcode.cn.five.three;

public class Solution {
  //  思路：记录当前最大值，从左往右遍历，如果已经<=0则从i+1重新开始计算
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      max = Math.max(max, sum);
      if (sum < 0) {
        sum = 0;
      }
    }
    return max;
  }
}
