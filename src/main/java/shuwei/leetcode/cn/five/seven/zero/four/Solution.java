package shuwei.leetcode.cn.five.seven.zero.four;

public class Solution {
  /**
   * 以k为端点求两边的最大值，然后合并起来,错误
   * 暴力，从k往右边计算，然后左边往左挪
   * @param nums
   * @param k
   * @return
   */
  public int maximumScore(int[] nums, int k) {
    int ans = 0;
    int minOuter = Integer.MAX_VALUE;
    for (int i = k; i >= 0; i--) {
      minOuter = Math.min(minOuter, nums[i]);
      ans = Math.max(ans, minOuter * (k - i + 1));
      int min = minOuter;
      for (int j = k + 1; j < nums.length; j++) {
        min = Math.min(min, nums[j]);
        ans = Math.max(ans, min * (j - i + 1));
      }
    }
    return ans;
  }
}
