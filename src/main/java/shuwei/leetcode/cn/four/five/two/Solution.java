package shuwei.leetcode.cn.four.five.two;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  /**
   * 有重叠区域的气球可以一起处理，不过会有这样的问题[1,4],[1,2],[3,5],[5,6] 如果把[1,4]和[3,5]放在一起则是不正确的 能否考虑先排序，然后从一边往另一边处理？
   */
  public int findMinArrowShots(int[][] points) {
    if (points.length < 1) {
      return 0;
    }
    if (points.length == 1) {
      return 1;
    }
    Arrays.sort(points, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
          if (o1[1] > o2[1]) {
            return 1;
          } else if (o1[1] == o2[1]) {
            return 0;
          } else {
            return -1;
          }
        } else {
          if (o1[0] > o2[0]) {
            return 1;
          } else {
            return -1;
          }
        }
      }
    });
    int ans = 0;
    int[] jiaoji = points[0];
    for (int i = 1; i < points.length; i++) {
      if (jiaoji[1] < points[i][0]) {
        // 无交集
        jiaoji = points[i];
        ans++;
      } else {
        jiaoji[0] = Math.max(jiaoji[0], points[i][0]);
        jiaoji[1] = Math.min(jiaoji[1], points[i][1]);
      }
    }
    if (jiaoji != null) {
      ans++;
    }
    return ans;
  }
}
