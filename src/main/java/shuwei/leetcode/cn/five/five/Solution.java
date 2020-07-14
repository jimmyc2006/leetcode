package shuwei.leetcode.cn.five.five;

public class Solution {
  public boolean canJump(int[] nums) {
    if (nums.length < 1) {
      return true;
    }
    int step = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      step = Math.max(--step, nums[i]);
      if (step == 0) {
        return false;
      }
    }
    return true;
  }
}
