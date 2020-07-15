package shuwei.leetcode.cn.one.one;

public class Solution {
  public int maxArea(int[] height) {
    int max = 0, lastH = 0;
    for(int i = 0, j = height.length - 1; i < j;) {
      if (height[i] <= lastH) {
        i++;
      }
      if (height[j] <= lastH) {
        j--;
      }
      if (height[i] > height[j]) {
        max = Math.max(max, (j - i) * height[j]);
        lastH = height[j];
        j--;
      } else {
        max = Math.max(max, (j - i) * height[i]);
        lastH = height[i];
        i++;
      }
    }
    return max;
  }
}
