package shuwei.leetcode.cn.one.three.four;

public class Solution {
  /**
   * 先计算差值，然后开始计算消耗，如果当前的值>0则重新计数
   * @param gas
   * @param cost
   * @return
   */
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int length = gas.length;
    int[] diff = new int[length];
    for (int i = 0; i < length; i++) {
      diff[i] = gas[i] - cost[i];
    }
    int start = 0;
    int currSum = 0;
    // 表示从i到j需要的前置变量,第一维下标是从哪开始，第二维0是开始位置，1是截止位置，2是需要额外花费
    int[][] need = new int[length][];
    for (int i = 0; i < length; i++) {
      currSum += diff[i];
      if (currSum < 0) {
        need[start] = new int[]{start, i + 1, -currSum};
        start = i + 1;
        currSum = 0;
      }
    }
    if (currSum < 0) {
      return -1;
    } else {
      if (start == 0) {
        return 0;
      } else {
        int[] next = need[0];
        while (next != null && currSum >= next[2]) {
          currSum -= next[2];
          next = need[next[1]];
        }
        if (next == null) {
          return start;
        } else {
          return -1;
        }
      }
    }
  }
}
