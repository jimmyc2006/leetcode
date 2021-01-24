package shuwei.leetcode.cn.six.seven.four;

public class Solution {
  public int findLengthOfLCIS(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }
    int ans = 1;
    int currLength = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] <= nums[i - 1]) {
        ans = Math.max(ans, currLength);
        currLength = 1;
      } else {
        currLength++;
      }
    }
    ans = Math.max(ans, currLength);
    return ans;
  }
}
