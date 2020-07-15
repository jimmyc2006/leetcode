package shuwei.leetcode.cn.two.zero.zero;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author shuwei
 * @version 创建时间：2020年4月20日 下午2:38:35 类说明
 */
public class Solution1 {
  
  // 广度优先算法,速度不快，5ms
  public int numIslands3(char[][] grid) {
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          grid[i][j] = '0';
          result++;
          bfs(grid, i, j);
        }
      }
    }
    return result;
  }
  
  private void bfs(char[][] grid, int i, int j) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {i, j});
    while(!q.isEmpty()) {
      int[] cur = q.poll();
      int[] next;
      while ((next = find(grid, cur[0], cur[1])) != null) {
        grid[next[0]][next[1]] = '0';
        q.add(new int[] {next[0], next[1]});
      }
    }
  }
  
  private int[] find(char[][] grid, int i, int j) {
    if (i -1 >= 0 && grid[i - 1][j] == '1') {
      return new int[] {i - 1, j};
    }
    if (i + 1 < grid.length && grid[i + 1][j] == '1') {
      return new int[] {i + 1, j};
    }
    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
      return new int[] {i, j - 1};
    }
    if (j + 1 < grid[i].length && grid[i][j + 1] == '1') {
      return new int[] {i, j + 1};
    }
    return null;
  }
  
  // 使用dfs
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length < 1) {
      return 0;
    }
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j =  0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          result++;
          dfs(i, j, grid);
        }
      }
    }
    return result;
  }
  
  private void dfs(int i, int j, char[][] grid) {
    if (grid[i][j] == '0') {
      return;
    } else {
      grid[i][j] = '0';
    }
    if (i + 1 < grid.length) {
      dfs(i+1, j, grid);
    }
    if (i - 1 >= 0) {
      dfs(i - 1, j, grid);
    }
    if (j + 1 < grid[i].length) {
      dfs(i, j + 1, grid);
    }
    if (j - 1 >= 0) {
      dfs(i, j - 1, grid);
    }
  }
  
  // 从左上往右下找，动态连通，只能打败35%用户
  public int numIslands1(char[][] grid) {
    if (grid == null || grid.length < 1) {
      return 0;
    }
    Map<Integer, Integer> unions = new HashMap<>();
    int[][] relation = new int[grid.length][grid[0].length];
    int result = 0;
    int sign = 1;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          // 上边
          if (i - 1 >= 0) {
            if (relation[i - 1][j] > 0) {
              relation[i][j] = relation[i - 1][j];
            }
          }
          // 左边
          if (j - 1 >= 0) {
            if (relation[i][j - 1] > 0) {
              if (relation[i][j] == 0) {
                relation[i][j] = relation[i][j - 1];
              } else {
                if (relation[i][j] != relation[i][j - 1]) {
                  // 判断是否连通过
                  if (!this.isUnion(relation[i][j], relation[i][j - 1], unions)) {
                    union(relation[i][j], relation[i][j - 1], unions);
                    result--;
                  }
                }
              }
            }
          }
          if (relation[i][j] == 0) {
            result++;
            relation[i][j] = sign;
            unions.put(sign, sign);
            sign++;
          }
        } else {
          relation[i][j] = 0;
        }
      }
    }
    return result;
  }
  
  public boolean isUnion(int i, int j, Map<Integer, Integer> unions) {
    return findval(i, unions) == findval(j, unions);
  }
  
  private int findval(int i, Map<Integer, Integer> unions) {
    int val = unions.get(i);
    while(val != i) {
      i = val;
      val = unions.get(i);
    }
    return val;
  }
  public void union(int i, int j, Map<Integer, Integer> unions) {
    int jVal = this.findval(j, unions);
    unions.put(jVal, i);
  }
}
