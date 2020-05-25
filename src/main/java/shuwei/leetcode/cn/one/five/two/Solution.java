package shuwei.leetcode.cn.one.five.two;

public class Solution {
  // dp,2ms beat 92%
  public int maxProduct(int[] nums) {
    int result = nums[0];
    int currMax = nums[0];
    int currMin = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int a = currMax * nums[i];
      int b = currMin * nums[i];
      currMax = Math.max(Math.max(a, b), nums[i]);
      currMin = Math.min(nums[i], Math.min(a, b));
      result = Math.max(result, currMax);
    }
    return result;
  }
  // 思路法， 2ms beat 92%
  public int maxProduct1(int[] nums) {
    int minNag = 0;
    int max = nums[0];
    int product = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        product = 0;
        minNag = 0;
        max = Math.max(max, 0);
      } else {
        if (product == 0) {
          product = nums[i];
        } else {
          product *= nums[i];
        }
        max = Math.max(max, product);
        if (minNag != 0) {
          max = Math.max(max, product / minNag);
        }
        if (nums[i] < 0 && minNag == 0) {
          minNag = product;
        }
      }
    }
    return max;
  }
}
