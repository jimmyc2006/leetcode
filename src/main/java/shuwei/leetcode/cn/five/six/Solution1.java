package shuwei.leetcode.cn.five.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shuwei
 * @version 创建时间：2020年4月16日 下午4:40:26 类说明
 */
public class Solution1 {

  public int[][] merge(int[][] intervals) {
    List<int[]> result = new ArrayList<>();
    if (intervals.length < 1) {
      return new int[][] {};
    }
    // 先根据左边的端点进行排序
    Arrays.sort(intervals, (x,y)->x[0]-y[0]);
    int min = intervals[0][0];
    int max = intervals[0][1];
    // 遍历数组，合并
    for (int i = 1; i < intervals.length; i++) {
      int curStart = intervals[i][0];
      int curEnd = intervals[i][1];
      if (curStart > max) {
        //  没交集需要重新创建一个结果集
        result.add(new int[] {min, max});
        min = curStart;
        max = curEnd;
      } else {
        max = Math.max(max, curEnd);
      }
    }
    result.add(new int[] {min, max});
    return result.toArray(new int[result.size()][2]);
  }
}
