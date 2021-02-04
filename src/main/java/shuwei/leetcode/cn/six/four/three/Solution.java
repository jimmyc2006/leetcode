package shuwei.leetcode.cn.six.four.three;

public class Solution {
  public double findMaxAverage(int[] nums, int k) {
    int max = 0;
    int curr = 0;
    for (int i =0 ; i < k; i++) {
      curr += nums[i];
    }
    max = curr;
    for (int i = k, j = 0; i < nums.length; i++) {
      curr -= nums[j++];
      curr += nums[i];
      max = Math.max(curr, max);
    }
    return (double)max / k;
  }
}
