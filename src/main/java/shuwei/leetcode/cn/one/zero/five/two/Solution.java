package shuwei.leetcode.cn.one.zero.five.two;

public class Solution {
  /**
   * 遍历一遍，记录当前满意的总用户数 使用滑动窗口记录长度X的最大捞回满意用户数 最后相加即为结果
   */
  public int maxSatisfied(int[] customers, int[] grumpy, int X) {
    int ans = 0, left = 0, currMax = 0, max = 0;
    for (int i = 0; i < customers.length; i++) {
      X--;
      if (grumpy[i] == 0) {
        ans += customers[i];
      } else {
        currMax += customers[i];
      }
      if (X <= 0) {
        max = Math.max(max, currMax);
        if (grumpy[left] == 1) {
          currMax = currMax - customers[left];
        }
        left++;
      }
    }
    return ans + max;
  }
}
