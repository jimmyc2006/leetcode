package shuwei.leetcode.cn.five.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public int[][] merge(int[][] intervals) {
    if (intervals.length <= 1) {
      return intervals;
    }
    // 根据数组第一个进行排序
    Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
    List<int[]> ans = new ArrayList<>();
    int[] cur = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
      if (cur[1] >= intervals[i][0]) {
        cur[1] = Math.max(cur[1], intervals[i][1]);
      } else {
        ans.add(cur);
        cur = intervals[i];
      }
    }
    if (ans.isEmpty() || ans.get(ans.size() - 1) != cur) {
      ans.add(cur);
    }
    int[][] result = new int[ans.size()][];
    for (int i = 0; i < ans.size(); i++) {
      result[i] = ans.get(i);
    }
    return result;
  }

}
