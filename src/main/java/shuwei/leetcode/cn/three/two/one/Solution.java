package shuwei.leetcode.cn.three.two.one;

public class Solution {
  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    StringBuilder sb = find(nums1, nums2, k, 0, 0);
    int[] ans = new int[sb.length()];
    for (int i = 0; i < sb.length(); i++) {
      ans[i] = sb.charAt(i) - '0';
    }
    return ans;
  }

  private StringBuilder find(int[] nums1, int[] nums2, int count, int start1, int start2) {
    if (count == 0) {
      return new StringBuilder();
    }
    int end1 = getEndIndex(nums1.length, count, nums2.length - start2);
    int[] max1 = findMax(nums1, start1, end1);
    int end2 = getEndIndex(nums2.length, count, nums1.length - start1);
    int[] max2 = findMax(nums2, start2, end2);
    StringBuilder res = new StringBuilder();
    if (max1[0] > max2[0]) {
      res.append(max1[0]).append(find(nums1, nums2, count - 1, max1[1] + 1, start2));
    } else if (max1[0] < max2[0]){
      res.append(max2[0]).append(find(nums1, nums2, count - 1, start1, max2[1] + 1));
    } else {
      StringBuilder s1 = find(nums1, nums2, count - 1, max1[1] + 1, start2);
      StringBuilder s2 = find(nums1, nums2, count - 1, start1, max2[1] + 1);
      res.append(max1[0]).append(s1.toString().compareTo(s2.toString()) > 0 ? s1: s2);
    }
    return res;
  }

  /**
   * 计算能选到的最大索引
   * @return
   */
  private int getEndIndex(int length, int count, int anotherLength) {
    if (anotherLength >= count) {
      return length;
    } else {
      return length - (count - anotherLength) + 1;
    }
  }

  private int[] findMax(int[] nums, int start, int end) {
    int max = 0;
    int index = 0;
    for (int i = start; i < end; i++) {
      if (nums[i] > max) {
        max = nums[i];
        index = i;
      }
    }
    return new int[]{max, index};
  }
}
