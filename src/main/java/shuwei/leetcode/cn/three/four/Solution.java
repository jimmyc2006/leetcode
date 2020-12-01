package shuwei.leetcode.cn.three.four;

public class Solution {

  /**
   * 二分查找，先找左边的目标：值是目标，它左边的index为0或者它左边的值不是target 然后再找右边的值
   */
  public int[] searchRange(int[] nums, int target) {
    if (nums.length < 1) {
      return new int[]{-1, - 1};
    }
    int leftIndex = myBinarySearch(nums, target, 0, nums.length - 1, true);
    if (leftIndex == -1) {
      return new int[]{-1, -1};
    }
    int rightIndex = myBinarySearch(nums, target, leftIndex, nums.length - 1, false);
    return new int[]{leftIndex, rightIndex};
  }

  // 找不到则返回-1
  private int myBinarySearch(int[] nums, int target, int start, int end, boolean isLeft) {
    if (start > end) {
      return -1;
    }
    int mid = (start + end) / 2;
    if (nums[mid] > target) {
      return myBinarySearch(nums, target, start, mid - 1, isLeft);
    } else if (nums[mid] < target) {
      return myBinarySearch(nums, target, mid + 1, end, isLeft);
    } else {
      if (isLeft) {
        if (mid == 0 || nums[mid - 1] != target) {
          return mid;
        } else {
          return myBinarySearch(nums, target, start, mid - 1, isLeft);
        }
      } else {
        if (mid == nums.length - 1 || nums[mid + 1] != target) {
          return mid;
        } else {
          return myBinarySearch(nums, target, mid + 1, end, isLeft);
        }
      }
    }
  }

}
