package shuwei.leetcode.cn.four;

public class Solution2 {
  // 看完官方题解思路以后
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    } else if (nums1.length < 1) {
      if (nums2.length % 2 == 1) {
        return nums2[nums2.length / 2];
      } else {
        return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0;
      }
    }
    int total = nums1.length + nums2.length;
    // 如果是奇数，让结果在分割线的右边
    int left = total / 2;
    int i = 0, j = 0, start = 0, end = nums1.length;
    // 有等号可能会多移动一次
    while (true) {
      // 这个可以保证i >= 1,从而保证i - 1 >= 0,下面就不用判断i - 1是否越界了
      // 这种代码逻辑是如何想到到？经验？
      i = start + (end - start) / 2;
      j = left - i;
      if (i < nums1.length && j > 0 && nums2[j - 1] > nums1[i]) {
        // 右移
        start = i + 1;
      } else if (i > 0 && nums1[i - 1] > nums2[j]) {
        // 左移
        end = i - 1;
      } else {
        break;
      }
    }
    int nums1LeftMax = i - 1 >= 0 ? nums1[i - 1]: Integer.MIN_VALUE;
    int nums1RightMin = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
    int nums2LeftMax = j - 1 >= 0 ? nums2[j - 1] : Integer.MIN_VALUE;
    int nums2RightMin = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;
    if (total % 2 == 1) {
      // 右边小的
      return Math.min(nums1RightMin, nums2RightMin);
    } else {
      return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
    }
  }
}
