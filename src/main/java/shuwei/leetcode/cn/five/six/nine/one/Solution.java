package shuwei.leetcode.cn.five.six.nine.one;

import java.util.Arrays;

public class Solution {

  /**
   * 两个数组都可以改不是只能改一个
   * @param nums1
   * @param nums2
   * @return
   */
  public int minOperations(int[] nums1, int[] nums2) {
    int length1 = nums1.length;
    int length2 = nums2.length;
    if (length1 > length2) {
      return minOpera(nums1, nums2);
    } else {
      return minOpera(nums2, nums1);
    }
  }

  // nums1比nums2长
  private int minOpera(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length * 6) {
      return -1;
    }
    int total1 = 0, total2 = 0;
    for (int i : nums1) {
      total1 += i;
    }
    for (int i : nums2) {
      total2 += i;
    }
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    if (total1 > total2) {
      return mm(nums2, nums1, total1 - total2);
    } else if(total1 == total2) {
      return 0;
    } else {
      return mm(nums1, nums2, total2 - total1);
    }
  }

  private int mm(int[] smaller, int[] bigger, int diff) {
    int smallIndex = 0;
    int bigIndex = bigger.length - 1;
    int ans = 0;
    while (diff > 0) {
      int sDiff = smallIndex == smaller.length ? 0 : 6 - smaller[smallIndex];
      int bDiff = bigIndex == bigger.length ? 0 : bigger[bigIndex] - 1;
      if (sDiff >= bDiff) {
        diff -= sDiff;
        smallIndex++;
      } else {
        diff -= bDiff;
        bigIndex--;
      }
      ans++;
    }
    return ans;
  }
}
