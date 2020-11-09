package shuwei.leetcode.cn.nine.seven.three;

import java.util.Arrays;

public class Solution1109 {

  public int[][] kClosest(int[][] points, int K) {
    // 先算平方和，排序，找结果
    int[] sum = new int[points.length];
    int[] arr = new int[points.length];
    for (int i = 0; i < points.length; i++) {
      sum[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
      arr[i] = sum[i];
    }
    Arrays.sort(arr);
    int index = 0;
    int[][] ans = new int[K][];
    for (int i = 0; i < sum.length; i++) {
      if (sum[i] < arr[K - 1]) {
        ans[index++] = points[i];
      }
    }
    if (index == K) {
      return ans;
    }
    for (int i = 0; i < sum.length; i++) {
      if (sum[i] == arr[K - 1]) {
        ans[index++] = points[i];
        if (index == K) {
          return ans;
        }
      }
    }
    return ans;
  }

}
