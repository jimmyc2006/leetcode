package shuwei.leetcode.cn.four.one.six;

import java.util.Arrays;

public class Solution {

  /**
   * 先计算总和，如果是奇数直接返回false 然后问题就变成如何用数组的自己来凑这个一半的值
   */
  public boolean canPartition(int[] nums) {
    int sum = 0;
    int max = nums[0];
    for (int ele : nums) {
      sum += ele;
      max = Math.max(max, ele);
    }
    if (sum % 2 != 0) {
      return false;
    } else {
      sum = sum / 2;
    }
    if (max > sum) {
      return false;
    }
    // 二维数组变成一维
    boolean[] dp = new boolean[sum + 1];
    dp[0] = true;
    for (int i = 0; i < nums.length; i++) {
      for (int j = sum; j >= nums[i]; j--) {
        dp[j] = dp[j] || dp[j - nums[i]];
        if (dp[sum]) {
          return true;
        }
      }
    }
    return dp[sum];
  }
//    // dp[i][j] 表示从0到i能否选出j
//    boolean[][] dp = new boolean[nums.length][sum + 1];
//    // 每一个都能选出来0，所以0都初始化为true
//    for (int i = 0; i < dp.length; i++) {
//      dp[i][0] = true;
//    }
//    for (int i = 1; i < nums.length; i++) {
//      for (int j = 0; j <= sum; j++) {
//        if (j >= nums[i]) {
//          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
//        } else {
//          dp[i][j] = dp[i - 1][j];
//        }
//        if (j == sum && dp[i][sum]) {
//          return true;
//        }
//      }
//    }
//    return dp[nums.length - 1][sum];
//  }

  // 每个数都有选择和不选择两种状态
  // 这种算法超出时间限制
  private boolean select(int[] nums, int index, int sum) {
    if (sum == 0) {
      return true;
    } else if (sum < 0) {
      return false;
    }
    if (index == nums.length) {
      return false;
    }
    if (select(nums, index + 1, sum - nums[index])) {
      return true;
    } else {
      return select(nums, index + 1, sum);
    }
  }
}
