package shuwei.leetcode.cn.four.nine.three;

import java.util.Arrays;

public class Solution {

  /**
   * 使用归并
   */
  public int reversePairs(int[] nums) {
    if (nums.length < 2) {
      return 0;
    }
    this.nums = nums;
    this.ans = 0;
    mergeCal(0, nums.length - 1);
    return ans;
  }

  private int ans;
  private int[] nums;

  private int[] mergeCal(int left, int right) {
    if (left == right) {
      return new int[]{nums[left]};
    }
    int mid = (left + right) / 2;
    int[] leftArr = mergeCal(left, mid);
    int[] rightArr = mergeCal(mid + 1, right);
    int indL = 0, indR = 0;
    int[] result = new int[right - left + 1];
    int index = 0;
    ans += cal(leftArr, rightArr);
    while (indL < leftArr.length || indR < rightArr.length) {
      while (indL < leftArr.length  && (indR == rightArr.length || leftArr[indL] <= rightArr[indR])) {
        result[index++] = leftArr[indL++];
      }
      while (indR < rightArr.length && (indL == leftArr.length || rightArr[indR] <= leftArr[indL])) {
        result[index++] = rightArr[indR++];
      }
    }
    return result;
  }

  int cal(int[] arr1, int[] arr2) {
    int res = 0;
    int i = 0, j = 0;
    while(i < arr1.length && j < arr2.length) {
//      if ((arr1[i] / 2 < arr2[j] || arr1[i] / 2 == arr2[j] && arr1[i] % 2 == 0)) { 这个公式不对，因为对2求余的时候需要判断正负性质
      if (arr1[i] <= arr2[j] * 2) {
        i++;
      } else {
        j++;
        System.out.println(j + ":" + (arr1.length - i));
        res += arr1.length - i;
      }
    }
    return res;
  }

}
