package shuwei.leetcode.cn.three.one.two;

public class Solution {
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
  public int maxCoins(int[] nums) {
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
