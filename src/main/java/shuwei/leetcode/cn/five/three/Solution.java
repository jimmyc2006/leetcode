package shuwei.leetcode.cn.five.three;

public class Solution {
  // dp,0ms beat
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }
    int result = nums[0];
    int prevMax = nums[0];
    for (int i = 1; i < nums.length; i++) {
      prevMax = Math.max(prevMax + nums[i], nums[i]);
      result = Math.max(result, prevMax);
    }
    return result;
  }
  //  思路：记录当前最大值，从左往右遍历，如果已经<=0则从i+1重新开始计算
  // 1ms,beat 95%
  public int maxSubArray1(int[] nums) {
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
