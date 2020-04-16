package shuwei.leetcode.cn.matrix01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shuwei 创建时间：2020年4月15日 下午5:47:07 广度优先搜索版本,参考shuwei.improve.sf1.graph 这个版本的性能只能超过70的代码
 *         耗时14
 */
public class Solution1 {
  public static void main(String[] args) {
    int[][] data = new int[][] {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
        {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
        {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
    Solution1 s = new Solution1();
    int[][] result = s.updateMatrix(data);
    for (int i = 0; i < result.length; i++) {
      System.out.println(Arrays.toString(result[i]));
    }
  }

  public int[][] updateMatrix(int[][] matrix) {
    int[][] result = new int[matrix.length][];
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < matrix.length; i++) {
      // 初始化结果数组
      result[i] = new int[matrix[i].length];
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          queue.add(new int[] {i, j});
        } else {
          result[i][j] = -1;
        }
      }
    }
    while (!queue.isEmpty()) {
      int[] p = queue.remove();
      addNext(p, result, queue);
    }
    return result;
  }

  public void addNext(int[] p, int[][] result, Queue<int[]> queue) {
    int x = p[0];
    int y = p[1];
    int deep = result[x][y] + 1;
    if (x - 1 >= 0 && result[x - 1][y] == -1) {
      result[x - 1][y] = deep;
      queue.add(new int[] {x - 1, y});
    }
    if (x + 1 < result.length && result[x + 1][y] == -1) {
      result[x + 1][y] = deep;
      queue.add(new int[] {x + 1, y});
    }
    if (y - 1 >= 0 && result[x][y - 1] == -1) {
      result[x][y - 1] = deep;
      queue.add(new int[] {x, y - 1});
    }
    if (y + 1 < result[x].length && result[x][y + 1] == -1) {
      result[x][y + 1] = deep;
      queue.add(new int[] {x, y + 1});
    }
  }
}
