package shuwei.leetcode.cn.four.five;

public class Solution {
  // 跳跃游戏 II
  // 每一个点到终点的最短距离，等于它能到达的点的最远距离加1
  // 优化：如果前一个点的值比后一个大，那么就不需要处理后面这个值了
  public int jump(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }
    int[] steps = new int[nums.length];
    steps[nums.length - 1] = 0;
    for (int i = nums.length - 2; i >= 0; i--) {
      if (i - 1 >= 0 && nums[i - 1] > nums[i]) {
        steps[i] = nums.length;
        continue;
      }
      int maxRange = nums[i];
      int minStep = nums.length;
      for (int j = 1; j <= maxRange && i + j < nums.length; j++) {
        minStep = Math.min(minStep, steps[i + j]);
      }
      steps[i] = minStep + 1;
    }
    return steps[0];
  }
}
