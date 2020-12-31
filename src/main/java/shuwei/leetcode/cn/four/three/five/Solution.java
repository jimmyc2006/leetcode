package shuwei.leetcode.cn.four.three.five;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  /**
   * 先排序，然后冲突的选择上限大的移除
   */
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length <= 1) {
      return 0;
    }
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] < o2[0]) {
          return -1;
        } else if (o1[0] > o2[0]) {
          return 1;
        } else {
          return 0;
        }
      }
    });
    int ans = 0;
    int[] curr = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
      if (curr[1] > intervals[i][0]) {
        ans++;
        // 有交集
        if (curr[1] > intervals[i][1]) {
          curr = intervals[i];
        }
      } else {
        curr = intervals[i];
      }
    }
    return ans;
  }
}
