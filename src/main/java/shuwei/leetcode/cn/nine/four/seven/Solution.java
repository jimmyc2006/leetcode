package shuwei.leetcode.cn.nine.four.seven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  /**
   * 先收集信息，然后从连接度最小且大于等于1的开始移除
   *
   * 开始的思路错误，改为动态连通性，将石头想象成成员，按编号排序
   * 两个石头相同x或者y，则连通
   * 连通后剩余的组的数量即为最后剩余的石头数量
   * 总数减去分组数即为答案
   */
  public int removeStones(int[][] stones) {
    Uniform uniform = new Uniform(stones.length);
    // 分组
    Map<Integer, List<Integer>> xMap = new HashMap<>();
    Map<Integer, List<Integer>> yMap = new HashMap<>();
    for (int i = 0; i < stones.length; i++) {
      add(stones[i][0], xMap, i);
      add(stones[i][1], yMap, i);
    }
    // 连通
    union(uniform, xMap);
    union(uniform, yMap);
    return stones.length - uniform.getGroup();
  }

  private void union(Uniform uniform, Map<Integer, List<Integer>> map) {
    for (List<Integer> ele : map.values()) {
      Integer pre = null;
      for (Integer index : ele) {
        if (pre == null) {
          pre = index;
        } else {
          uniform.union(pre, index);
          pre = index;
        }
      }
    }
  }

  private void add(int n, Map<Integer, List<Integer>> map, int index) {
    List<Integer> integers = map.get(n);
    if (integers == null) {
      integers = new ArrayList<>();
      map.put(n, integers);
    }
    integers.add(index);
  }
}
class Uniform {
  private int[] points;
  private int group;

  public Uniform(int N) {
    group = N;
    points = new int[N];
    for (int i = 0; i < N; i++) {
      points[i] = i;
    }
  }

  public int find(int point) {
    if (point != points[point]) {
      points[point] = find(points[point]);
    }
    return points[point];
  }

  public void union(int p1, int p2) {
    int p1f = find(p1);
    int p2f = find(p2);
    if (p1f == p2f) {
      return;
    }
    points[p1f] = p2f;
    group--;
  }

  public int getGroup() {
    return group;
  }
}