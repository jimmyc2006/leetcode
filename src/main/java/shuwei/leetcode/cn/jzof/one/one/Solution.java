package shuwei.leetcode.cn.jzof.one.one;

public class Solution {
  public int minArray(int[] numbers) {
    return min(numbers, 0, numbers.length);
  }


  private int min(int[] nums, int start, int end) {
    if (start + 1 == end) {
      return nums[start];
    }
    int mid = start + (end - start) / 2;
    if (nums[mid] > nums[0]) {
      return Math.min(nums[0],min(nums, mid, end));
    } else if (nums[mid] < nums[0]) {
      if (mid - 1 >= 0 &&  nums[mid - 1] <= nums[mid]) {
        return min(nums, start, mid);
      } else {
        return nums[mid];
      }
    } else {
      // 等于
      if (nums[mid] > nums[end - 1]) {
        return min(nums, mid, end);
      } else {
        int min1 = min(nums, start, mid);
        if (min1 < nums[mid]) {
          return min1;
        } else {
          return min(nums, mid, end);
        }
      }
    }
  }
}