package shuwei.leetcode.cn.one.six.three.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Solution {
  public int minimumEffortPath(int[][] heights) {
    int xLength = heights.length;
    int yLength = heights[0].length;
    int N = xLength * yLength;
    Uniform uniform = new Uniform(N);
    List<int[]> data = new ArrayList<>();
    for (int i = 0; i < xLength; i++) {
      for (int j = 0 ; j < yLength; j++) {
        if (i + 1 < xLength) {
          data.add(new int[]{Math.abs(heights[i][j] - heights[i + 1][j]), yLength * i + j, yLength * (i + 1) + j});
        }
        if (j + 1 < yLength) {
          data.add(new int[]{Math.abs(heights[i][j] - heights[i][j + 1]), yLength * i + j, yLength * i + j + 1});
        }
      }
    }
    Collections.sort(data, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });
    int ans = 0;
    int index = N - 1;
    for (int[] ele : data) {
      uniform.union(ele[1], ele[2]);
      ans = Math.max(ans, ele[0]);
      if (uniform.isConnection(0, index)) {
        return ans;
      }
    }
    return ans;
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

  public boolean isConnection(int p1, int p2) {
    return find(p1) == find(p2);
  }

  public int find(int point) {
    if (point != points[point]) {
      points[point] = find(points[point]);
    }
    return points[point];
  }

  public boolean union(int p1, int p2) {
    int p1f = find(p1);
    int p2f = find(p2);
    if (p1f == p2f) {
      return false;
    }
    points[p1f] = p2f;
    group--;
    return true;
  }

  public int getGroup() {
    return group;
  }
}