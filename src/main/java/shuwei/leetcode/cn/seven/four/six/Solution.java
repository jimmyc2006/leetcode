package shuwei.leetcode.cn.seven.four.six;

public class Solution {

  /**
   * dp的思路fee[i] = min(fee[i - 2], fee[i - 1]) + fee[i]
   * @param cost
   * @return
   */
  public int minCostClimbingStairs(int[] cost) {
    int pre = cost[0];
    int sufix = cost[1];
    if (cost.length == 2) {
      return sufix;
    }
    int curr = 0;
    for (int i = 2; i < cost.length; i++) {
      curr = Math.min(pre, sufix) + cost[i];
      pre = sufix;
      sufix = curr;
    }
    return Math.min(pre, sufix);
  }
}
