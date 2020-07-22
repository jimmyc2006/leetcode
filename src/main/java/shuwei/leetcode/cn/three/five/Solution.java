package shuwei.leetcode.cn.three.five;

public class Solution {
  public int searchInsert(int[] nums, int target) {
    if (nums.length < 1) {
      return 0;
    }
    return b(nums, 0, nums.length, target);
  }
  private int b(int[] nums, int start, int end, int target) {
    if (start == end) {
      return start;
    }
    int mid = (start + end) / 2;
    if(target > nums[mid]) {
      return b(nums, mid + 1, end, target);
    } else if (target < nums[mid]) {
      return b(nums, start, mid, target);
    } else {
      return mid;
    }
  }
}
