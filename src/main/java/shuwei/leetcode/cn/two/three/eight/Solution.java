package shuwei.leetcode.cn.two.three.eight;

public class Solution {
  // 1ms 100%
  public int[] productExceptSelf(int[] nums) {
    if (nums.length <= 1) {
      return nums;
    }
    int[] result = new int[nums.length];
    result[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      result[i] = result[i - 1] * nums[i - 1];
    }
    int sum = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      result[i] = sum * result[i];
      sum = sum * nums[i];
    }
    return result;
  }

}
