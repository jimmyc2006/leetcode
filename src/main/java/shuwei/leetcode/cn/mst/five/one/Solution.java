package shuwei.leetcode.cn.mst.five.one;

import java.util.Arrays;

public class Solution {

  // 由于返回新数组的时候，需要使用一个全局变量来记录结果，所以本次采用单步返回结果的方式
  // 需要对原有数组进行操作
  public int reversePairs(int[] nums) {
    if (nums.length < 2) {
      return 0;
    }
    return merge(nums, 0, nums.length - 1);
  }

  private int merge(int[] nums, int start, int end) {
    if (start == end) {
      return 0;
    }
    int mid = start + (end - start) / 2;
    int leftCount = merge(nums, start, mid);
    int rightCount = merge(nums, mid + 1, end);
    int currCount = 0;
    int[] leftArr = Arrays.copyOfRange(nums, start, mid + 1);
    int[] rightArr = Arrays.copyOfRange(nums, mid + 1, end + 1);
    int leftIndex = 0, rightIndex = 0;
    for (int i = start; i <= end; i++) {
      if (leftIndex == leftArr.length) {
        nums[i] = rightArr[rightIndex++];
      } else if (rightIndex == rightArr.length) {
        nums[i] = leftArr[leftIndex++];
      } else if (leftArr[leftIndex] <= rightArr[rightIndex]) {
        nums[i] = leftArr[leftIndex++];
      } else {
        currCount += leftArr.length - leftIndex;
        nums[i] = rightArr[rightIndex++];
      }
    }
    return leftCount + rightCount + currCount;
  }
}
