package shuwei.leetcode.cn.six.eight.five;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  /**
   * 一个顶点被指向2次，那么这个顶点是矛盾点需要处理
   * 一个顶点出去多次，那么这个顶点就是起始点
   * 没有作为过目标的才是头部
   * 如果
   * @param edges
   * @return
   */
  public int[] findRedundantDirectedConnection(int[][] edges) {
    Map<Integer, int[]> targetMap = new HashMap<>();
    Set<Integer> fromSet = new HashSet<>();
    Integer from0 = null;
    Integer from1 = null;
    Integer sameTarget = null;
    Integer start = null;
    // {4, 2}, {1, 5}, {5, 2}, {5, 3}, {2, 4}
    for (int i = 0; i < edges.length; i++) {
      fromSet.add(edges[i][0]);
      if (targetMap.containsKey(edges[i][1])) {
        // 可能是头部
        if (targetMap.get(edges[i][1]) == null) {
          return edges[i];
        } else {
          from0 = edges[i][0];
          from1 = targetMap.get(edges[i][1])[0];
          sameTarget = edges[i][1];
        }
      } else {
        targetMap.put(edges[i][1], edges[i]);
      }
      if (targetMap.containsKey(from0) && targetMap.containsKey(from1)) {
        return new int[]{Math.max(from0, from1), sameTarget};
      }
    }
    if (targetMap.containsKey(from0)) {
      return new int[]{from0, sameTarget};
    }
    if (targetMap.containsKey(from1)) {
      return new int[]{from1, sameTarget};
    }
    return null;
  }

}
