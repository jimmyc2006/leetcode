package shuwei.leetcode.cn.four.eight.six;

public class Solution {
  /**
   * 采用dp方法，每新增一个数，每一步分为2中情况，其中选新加这个数的结果应该是之前都算过的
   * dp[i][j][0]表示先拿的人拿到的最大数
   * dp[i][j][1]表示i到j后拿的数
   */
  public boolean PredictTheWinner(int[] nums) {
    int length = nums.length;
    dp = new int[length][length][2];
    findMax(nums, 0, length - 1);
    return dp[0][length - 1][0] >= dp[0][length - 1][1];
  }

  private int[][][] dp;

  private int[] findMax(int[] nums, int start, int end) {
    if (start > end) {
      return new int[]{0, 0};
    }
    if (start == end) {
      dp[start][end][0] = nums[start];
      dp[start][end][1] = 0;
      return new int[]{nums[start], 0};
    }
    if (dp[start][end][0] > 0) {
      return new int[]{dp[start][end][0], dp[start][end][1]};
    }
    int[] takeLeft = findMax(nums, start + 1, end);
    int num1 = nums[start] + takeLeft[1];
    int[] takeRight = findMax(nums, start, end - 1);
    int num2 = nums[end] + takeRight[1];
    if (num1 >= num2) {
      dp[start][end][0] = num1;
      dp[start][end][1] = takeLeft[0];
    } else {
      dp[start][end][0] = num2;
      dp[start][end][1] = takeRight[0];
    }
    return new int[]{dp[start][end][0], dp[start][end][1]};
  }
}
