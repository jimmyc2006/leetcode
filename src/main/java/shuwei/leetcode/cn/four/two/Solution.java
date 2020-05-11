package shuwei.leetcode.cn.four.two;

public class Solution {
  public int trap(int[] height) {
    if (height == null | height.length < 2) {
      return 0;
    }
    int[] sign = new int[height.length];
    // 从左向右更新某个点的左边最高的柱子
    int max =0 ;
    for (int i = 0; i < height.length; i++) {
      sign[i] = max;
      max = Math.max(max, height[i]);
    }
    max = 0;
    // 从右往左更新某个点的右边最高的柱子
    for (int i = height.length - 1; i >= 0; i--) {
      sign[i] = Math.min(sign[i], max);
      max = Math.max(max, height[i]);
    }
    // 求值
    int sum = 0;
    for (int i = 0; i < height.length; i++) {
      int diff = sign[i] - height[i];
      if (diff > 0) {
        sum += diff;
      }
    }
    return sum;
  }
}
