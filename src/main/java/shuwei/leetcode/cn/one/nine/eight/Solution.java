package shuwei.leetcode.cn.one.nine.eight;

public class Solution {
  // dp
  public int rob(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }
    int[] f = new int[nums.length];
    f[0] = nums[0];
    for (int i =1 ;i < nums.length; i++) {
      if (i - 2 >= 0) {
        f[i] = Math.max(f[i - 1], nums[i] + f[i - 2]);
      } else {
        f[i] = Math.max(nums[i], f[i - 1]);
      }
    }
    return f[nums.length - 1];
  }
}