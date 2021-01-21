package shuwei.leetcode.cn.one.four.eight.nine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import shuwei.leetcode.cn.Uniform;

public class Solution {

  /**
   * 克鲁斯卡尔算法
   * @param n
   * @param edges
   * @return
   */
  public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
    // 创建一个数组，存储edges的长度，from，to，序号，然后将这个数组排序，展开克鲁斯卡尔算法
    int[][] data = new int[edges.length][];
    for (int i = 0; i < edges.length; i++) {
      data[i] = new int[]{edges[i][2], edges[i][0], edges[i][1], i};
    }
    Arrays.sort(data, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0]-o2[0];
      }
    });
    // Set<Integer>记录选中的边
    Set<Integer> shortestLines = new HashSet<>(n - 1);
    Uniform uniform = new Uniform(n);
    // 最短边的总和
    int minRes = 0;
    for (int[] line : data) {
      if (!uniform.isConnection(line[1], line[2])) {
        minRes += line[0];
        shortestLines.add(line[3]);
        uniform.union(line[1], line[2]);
      }
      if (uniform.getGroup() == 1) {
        break;
      }
    }
    List<Integer> must = new ArrayList<>();
    List<Integer> notMust = new ArrayList<>();
    for (int i = 0; i < edges.length; i++) {
      if (shortestLines.contains(i)) {
        if (calMinExclude(n, data, i) == minRes) {
          notMust.add(i);
        } else {
          must.add(i);
        }
      } else {
        if (calMinInclude(n, data, i, edges) == minRes) {
          notMust.add(i);
        }
      }
    }
    return Arrays.asList(must, notMust);
  }

  private int calMinExclude(int n, int[][] data, int exclude) {
    int result = 0;
    Uniform uniform = new Uniform(n);
    // 最短边的总和
    for (int[] line : data) {
      if (!uniform.isConnection(line[1], line[2]) && line[3] != exclude) {
        result += line[0];
        uniform.union(line[1], line[2]);
      }
      if (uniform.getGroup() == 1) {
        break;
      }
    }
    return result;
  }
  private int calMinInclude(int n, int[][] data, int include, int[][] edges) {
    int result = edges[include][2];
    Uniform uniform = new Uniform(n);
    uniform.union(edges[include][0], edges[include][1]);
    // 最短边的总和
    for (int[] line : data) {
      if (!uniform.isConnection(line[1], line[2])) {
        result += line[0];
        uniform.union(line[1], line[2]);
      }
      if (uniform.getGroup() == 1) {
        break;
      }
    }
    return result;
  }
}
