package shuwei.leetcode.cn.three.one.two;

import java.util.Arrays;

public class Solution {
  // 复习2020-11-18
  public int maxCoins(int[] nums) {
    int length = nums.length;
    // dp[i][j][k] 表示戳破i和k之间的j可得的分数
    // dp[i][k]之间的最大值是
    int[] data = new int[length + 2];
    data[0] = 1;
    System.arraycopy(nums, 0, data, 1, length);
    data[length + 1] = 1;
    int[][] dp = new int[data.length][data.length];
    deal(0, data.length - 1, dp, data);
    return dp[0][data.length - 1];
  }
  private int deal(int start, int end, int[][] dp, int[] data) {
    if (start >= end - 1) {
      return 0;
    }
    if (dp[start][end] > 0) {
      return dp[start][end];
    }
    int max = 0;
    for (int i = start + 1; i < end; i++) {
      max = Math.max(max, deal(start, i, dp, data) + deal(i, end, dp, data) + data[i] * data[start] * data[end]);
    }
    dp[start][end] = max;
    return max;
  }

  /**
   * 思路：采用逆序的dp，dp[i][j]表示戳i到j的气球，但是不包含i 和j
   * 那么就可以创造一个左边界为1，右边界为1的数组
   * dp[i][j] = max(dp[i][k] + dp[k][j] + nums[i]*nums[k]*nums[j])
   * k的取值范围是从 i + 1 到 j - 1,j需要比i大2
   * 意思是当dp[i][k]都戳完了，dp[k][j]都戳完了，最后戳k时候的值，最大值应该是从k为i+1到j-1
   * 由于i，j, k的顺序错误的话，会造成错误的结果，我这里采用的思路是：
   * 从左往右计算，由于没有算过的都是0，所以采用从右往左算，这个需要写出代码以后调试
   * 即使dp公式有了以后，也需要控制循环次数，才能达到后面的用到前面的结果
   *
   */
  public int maxCoins1(int[] nums) {
    int length = nums.length;
    int[][] dp = new int[length + 2][length + 2];
    int[] vals = new int[length + 2];
    vals[0] = 1;
    vals[length + 1] = 1;
    for (int i = 1; i <= length; i++) {
      vals[i] = nums[i - 1];
    }
    for (int j = 2 ; j < length + 2; j++) {
      for (int i = j - 2; i >= 0; i--) {
        for (int k = j - 1; k > i; k--) {
          dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + vals[i] * vals[k] * vals[j]);
        }
      }
    }
    return dp[0][length + 1];
  }
}
