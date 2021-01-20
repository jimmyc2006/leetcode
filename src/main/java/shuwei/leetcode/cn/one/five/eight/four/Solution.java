package shuwei.leetcode.cn.one.five.eight.four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
  /**
   * 思路：从第一个点开始，每次都寻找离当前集合最近的点加入到集合中
   *
   * @param points
   * @return
   */
  public int minCostConnectPoints(int[][] points) {
    length = points.length;
    int ans = 0;
    boolean[] isConnect = new boolean[points.length];
    // 已经被处理的点的集合,map的key是距离，值是点顺序的集合
    Map<Integer, TreeMap<Integer, List<Integer>>> dis = new HashMap<>();
    dis.put(0, this.culDis(points, 0, isConnect));
    while (dis.size() < length) {
      int[] nearest = this.findNearest(dis, isConnect);
      ans += nearest[0];
      TreeMap<Integer, List<Integer>> integerListTreeMap = this.culDis(points, nearest[1], isConnect);
      dis.put(nearest[1], integerListTreeMap);
    }
    return ans;
  }

  private int length;

  private TreeMap<Integer, List<Integer>> culDis(int[][] points, int currIndex, boolean[] isConn) {
    TreeMap<Integer, List<Integer>> result = new TreeMap<>();
    int x = points[currIndex][0];
    int y = points[currIndex][1];
    isConn[currIndex] = true;
    for (int i = 0; i < length; i++) {
      if(isConn[i]) {
        continue;
      }
      int dis = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
      List<Integer> disIndexs = result.get(dis);
      if (disIndexs == null) {
        disIndexs = new LinkedList<>();
        result.put(dis, disIndexs);
      }
      disIndexs.add(i);
    }
    return result;
  }

  private int[] findNearest(Map<Integer, TreeMap<Integer, List<Integer>>> disList, boolean[] isConn) {
    int minDis = Integer.MAX_VALUE;
    int minDisIndex = 0;
    for (TreeMap<Integer, List<Integer>> disTreeMap : disList.values()) {
      int[] theMin = getMin(disTreeMap, isConn);
      if (theMin[0] < minDis) {
        minDis = theMin[0];
        minDisIndex = theMin[1];
      }
    }
    return new int[]{minDis, minDisIndex};
  }

  private int[] getMin(TreeMap<Integer, List<Integer>> disMap, boolean[] isConn) {
    int index = -1;
    int minDis = -1;
    while (index == -1) {
      Map.Entry<Integer, List<Integer>> firstEntry = disMap.firstEntry();
      List<Integer> value = firstEntry.getValue();
      List<Integer> removed = new ArrayList<>();
      for (Integer ind : value) {
        if (!isConn[ind]) {
          index = ind;
          minDis = firstEntry.getKey();
        } else {
          removed.add(ind);
        }
      }
      if (removed.size() == value.size()) {
        disMap.remove(firstEntry.getKey());
      } else {
        for (Integer ele : removed) {
          value.remove(ele);
        }
      }
    }
    return new int[]{minDis, index};
  }
}
