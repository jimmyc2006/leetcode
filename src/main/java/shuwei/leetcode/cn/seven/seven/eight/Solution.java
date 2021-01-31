package shuwei.leetcode.cn.seven.seven.eight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import shuwei.leetcode.cn.Uniform;

public class Solution {

  /**
   * 每一个位置与另一位置连通的成本就是它们之间值比较大的，这个跟上一个题很类似
   * @param grid
   * @return
   */
  public int swimInWater(int[][] grid) {
    int N = grid.length;
    if (N == 1) {
      return grid[0][0];
    }
    Uniform uniform = new Uniform(N * N);
    // 存放成本和连接的2个点
    List<int[]> data = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (i + 1 < N) {
          data.add(new int[]{Math.max(grid[i][j], grid[i + 1][j]), N * i + j, N * (i + 1) + j});
        }
        if (j + 1 < N) {
          data.add(new int[]{Math.max(grid[i][j], grid[i][j + 1]), N * i + j, N * i + j + 1});
        }
      }
    }
    // 排序
    Collections.sort(data, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });
    int ans = 0;
    int lastIndex = N * N - 1;
    for (int[] ele : data) {
      ans = Math.max(ans, ele[0]);
      uniform.union(ele[1], ele[2]);
      if (uniform.isConnection(0, lastIndex)) {
        return ans;
      }
    }
    return ans;
  }
}
