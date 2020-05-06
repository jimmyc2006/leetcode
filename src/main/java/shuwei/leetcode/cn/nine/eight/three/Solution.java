package shuwei.leetcode.cn.nine.eight.three;

public class Solution {
  // 类似dp的方法，每一个点的最少费用等于使用1天，7天和30天费用的最小值
  public int mincostTickets(int[] days, int[] costs) {
    if (days == null || days.length < 1) {
      return 0;
    }
    int[] minFee = new int[days.length + 1];
    for (int i = days.length - 1; i >= 0; i--) {
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < 3; j++) {
        min = Math.min(min, costs[j] + minFee[fee(days, i, j)]);
      }
      minFee[i] = min;
    }
    return minFee[0];
  }
  
  // 花cost[j]的钱买票
  private int fee(int[] days, int i, int j) {
    int duration;
    if (j == 0) {
      duration = 1;
    } else if (j == 1) {
      duration = 7;
    } else {
      duration = 30;
    }
    int start = days[i];
    int end = start + duration; // 1 + 1 = 2，并不包含第2天
    while (i < days.length && days[i] < end) {
      i++;
    }
    return i;
  }
}
