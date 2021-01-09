package shuwei.leetcode.cn.one.eight.nine;

public class Solution {

  public void rotate(int[] nums, int k) {
      int length = nums.length;
      if (length < 1) {
        return;
      }
      if (k >= length) {
        k = k % length;
      }
      for (int i = length - 1; i >= 0; i--) {
        if (i - k >= 0) {
          nums[i] = nums[i - k];
        } else {
          nums[i] = nums[i + i - k];
        }
      }
  }

//  public void rotate(int[] nums, int k) {
//    int length = nums.length;
//    if (length < 1) {
//      return;
//    }
//    if (k >= length) {
//      k = k % length;
//    }
//    if (k < length - k) {
//      for (int i = 0; i < k; i++) {
//        int tmp = nums[length - 1];
//        for (int j = length - 1; j > 0; j--) {
//          nums[j] = nums[j - 1];
//        }
//        nums[0] = tmp;
//      }
//    } else {
//      for (int i = 0; i < length - k; i++) {
//        int tmp = nums[0];
//        for (int j = 0; j < length - 1; j++) {
//          nums[j] = nums[j + 1];
//        }
//        nums[length - 1] = tmp;
//      }
//    }
//  }
}
