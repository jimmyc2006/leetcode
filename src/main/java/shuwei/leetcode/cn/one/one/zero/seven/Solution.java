package shuwei.leetcode.cn.one.one.zero.seven;

import java.util.Arrays;

public class Solution {

  public int countRangeSum(int[] nums, int lower, int upper) {
    if (nums.length < 1) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0] >= lower && nums[0] <= upper ? 1 : 0;
    }
    long[] preSum = new long[nums.length];
    preSum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      preSum[i] = preSum[i - 1] + nums[i];
    }
    return cal(preSum, 0, preSum.length - 1, lower, upper);
  }

  // 包含start，包含end
  // 采用内部修改数组值，返回符合条件的结果的方式
  private int cal(long[] preSum, int start, int end, int lower, int upper) {
    if (start == end) {
      return preSum[start] >= lower && preSum[start] <= upper ? 1 : 0;
    }
    int ans = 0;
    int mid = start + (end - start) / 2;
    int left = cal(preSum, start, mid, lower, upper);
    int right = cal(preSum, mid + 1, end, lower, upper);
    // 算自己
    int leftIndex = mid + 1;
    int rigthIndex = mid + 1;
    for (int i = start; i <= mid; i++) {
      while (leftIndex <= end && preSum[leftIndex] - preSum[i] < lower) {
        leftIndex++;
      }
      while (rigthIndex <= end && preSum[rigthIndex] - preSum[i] <= upper) {
        rigthIndex++;
      }
      if (rigthIndex > leftIndex) {
        ans += rigthIndex - leftIndex;
      }
      // 改变顺序
    }
    long[] leftData = Arrays.copyOfRange(preSum, start, mid + 1);
    long[] rightData = Arrays.copyOfRange(preSum, mid + 1, end + 1);
    int lInd = 0, rInd = 0;
    for (int i = start; i <= end; i++) {
      if (lInd == leftData.length) {
        preSum[i] = rightData[rInd++];
      } else if (rInd == rightData.length) {
        preSum[i] = leftData[lInd++];
      } else if (leftData[lInd] < rightData[rInd]) {
        preSum[i] = leftData[lInd++];
      } else {
        preSum[i] = rightData[rInd++];
      }
    }
    return ans + left + right;
  }

}
