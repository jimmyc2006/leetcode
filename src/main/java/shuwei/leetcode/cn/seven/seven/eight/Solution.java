package shuwei.leetcode.cn.seven.seven.eight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
  /**
   * 0131学习狄杰斯特拉算法
   */
  public int swimInWater(int[][] grid) {
    int n = grid.length;

    Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> grid[o[0]][o[1]]));
    minHeap.offer(new int[]{0, 0});

    boolean[][] visited = new boolean[n][n];
    // distTo[i][j] 表示：到顶点 [i, j] 须要等待的最少的时间
    int[][] distTo = new int[n][n];
    for (int[] row : distTo) {
      Arrays.fill(row, n * n);
    }
    distTo[0][0] = grid[0][0];

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    while (!minHeap.isEmpty()) {
      // 找最短的边
      int[] front = minHeap.poll();
      int currentX = front[0];
      int currentY = front[1];
      if (visited[currentX][currentY]) {
        continue;
      }

      // 确定最短路径顶点
      visited[currentX][currentY] = true;
      if (currentX == n - 1 && currentY == n - 1) {
        return distTo[n - 1][n - 1];
      }

      // 更新
      for (int[] direction : directions) {
        int newX = currentX + direction[0];
        int newY = currentY + direction[1];
        if (inArea(newX, newY, n) && !visited[newX][newY] &&
                Math.max(distTo[currentX][currentY], grid[newX][newY]) < distTo[newX][newY]) {
          distTo[newX][newY] = Math.max(distTo[currentX][currentY], grid[newX][newY]);
          // 狄杰斯特拉的精髓，每次从当前最短的开始找
          minHeap.offer(new int[]{newX, newY});
        }
      }
    }
    return -1;
  }

  private boolean inArea(int x, int y, int n) {
    return x >= 0 && x < n && y >= 0 && y < n;
  }

  /**
   * 每一个位置与另一位置连通的成本就是它们之间值比较大的，这个跟上一个题很类似
   * @param grid
   * @return
   */
//  public int swimInWater(int[][] grid) {
//    int N = grid.length;
//    if (N == 1) {
//      return grid[0][0];
//    }
//    Uniform uniform = new Uniform(N * N);
//    // 存放成本和连接的2个点
//    List<int[]> data = new ArrayList<>();
//    for (int i = 0; i < N; i++) {
//      for (int j = 0; j < N; j++) {
//        if (i + 1 < N) {
//          data.add(new int[]{Math.max(grid[i][j], grid[i + 1][j]), N * i + j, N * (i + 1) + j});
//        }
//        if (j + 1 < N) {
//          data.add(new int[]{Math.max(grid[i][j], grid[i][j + 1]), N * i + j, N * i + j + 1});
//        }
//      }
//    }
//    // 排序
//    Collections.sort(data, new Comparator<int[]>() {
//      @Override
//      public int compare(int[] o1, int[] o2) {
//        return o1[0] - o2[0];
//      }
//    });
//    int ans = 0;
//    int lastIndex = N * N - 1;
//    for (int[] ele : data) {
//      ans = Math.max(ans, ele[0]);
//      uniform.union(ele[1], ele[2]);
//      if (uniform.isConnection(0, lastIndex)) {
//        return ans;
//      }
//    }
//    return ans;
//  }
}
