package shuwei.leetcode.cn.two.zero.nine;

public class Solution {
  public int minSubArrayLen(int s, int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }
    int start = 0, sum = 0, ans = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length;) {
      sum += nums[i++];
      while (sum >= s) {
        ans = Math.min(ans, i - start);
        sum -= nums[start++];
      }
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }
}
