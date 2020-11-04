package shuwei.leetcode.cn.five.seven;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  /**
   * 思路：
   * 先使用新的数组的开始位置，遇到某个成员的和这个数组有交集，那么就取出来左端点
   * 使用两者比较大的元素作为当前最大值，遍历后面的数组的时候，只要开始值小于等于这个值，就更新当前最大值
   * @param intervals
   * @param newInterval
   * @return
   */
  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals.length < 1) {
      return new int[][]{newInterval};
    }
    if (newInterval.length < 1) {
      return intervals;
    }
    List<int[]> result = new ArrayList<>();
    boolean isAddNewInterval = false;
    for (int i = 0; i < intervals.length; i++) {
      int[] ele = intervals[i];
      if (newInterval[0] > ele[1]) {
        result.add(ele);
        // 如果是最后一个，就加一下
        if (i == intervals.length - 1) {
          result.add(newInterval);
        }
      } else if (ele[0] > newInterval[1]) {
        if (!isAddNewInterval) {
          result.add(newInterval);
          isAddNewInterval = true;
        }
        result.add(ele);
      } else {
        // 有交集
        newInterval[0] = Math.min(ele[0], newInterval[0]);
        newInterval[1] = Math.max(ele[1], newInterval[1]);
        if (i == intervals.length - 1) {
          result.add(newInterval);
        }
      }
    }
    return result.toArray(new int[result.size()][]);
  }

}
