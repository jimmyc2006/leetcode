package shuwei.leetcode.cn.jz.five.three;

public class Solution {
  public int missingNumber(int[] nums) {
    // 二分
    int start = 0, end = nums.length;
    while (start < end) {
      int mid = (start + end) / 2;
      if (mid == nums[mid]) {
        start = mid + 1;
      } else if (mid < nums[mid]) {
        end = mid - 1;
      }
    }
    if (start == nums.length) {
      return nums.length;
    }
    if (start == nums[start]) {
      return start + 1;
    } else {
      return start;
    }
  }
}
