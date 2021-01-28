package shuwei.leetcode.cn.seven.two.four;

public class Solution {
  public int pivotIndex(int[] nums) {
    int length = nums.length;
    if (length == 0) {
      return -1;
    }
    int[] preSum = new int[length];
    int currSum = 0;
    for (int i = 0; i < length; i++) {
      currSum += nums[i];
      preSum[i] = currSum;
    }
    for (int i = 0; i < length; i++) {
      if (preSum[i] - nums[i] == preSum[length - 1] - preSum[i]) {
        return i;
      }
    }
    return -1;
  }
}
