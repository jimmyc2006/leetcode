package shuwei.leetcode.cn.three.three;

public class Solution {
  
  public int search(int[] nums, int target) {
    if (nums == null || nums.length < 1) {
      return -1;
    }
    int startIndex = 0;
    int endIndex = nums.length - 1;
    while (true) {
      int middleLength = (endIndex - startIndex) / 2;
      int middleIndex = startIndex + middleLength;
      if (target == nums[startIndex]) {
        return startIndex;
      } else if (target == nums[endIndex]) {
        return endIndex;
      } else if (nums[middleIndex] == target) {
        return middleIndex;
      }
      if (target < nums[middleIndex]) {
        if (target > nums[0]) {
          endIndex = middleIndex;
        } else {
          if (nums[middleIndex] > nums[0]) {
            startIndex = middleIndex;
          } else {
            endIndex = middleIndex;
          }
        }
      } else {
        if (target < nums[0]) {
          startIndex = middleIndex;
        } else {
          if (nums[middleIndex] > nums[0]) {
            startIndex = middleIndex;
          } else {
            endIndex = middleIndex;
          }
        }
      }
      if (middleLength == 0) {
        return -1;
      }
    }
  }
}
