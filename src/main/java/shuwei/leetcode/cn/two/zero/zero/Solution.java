package shuwei.leetcode.cn.two.zero.zero;


public class Solution {
  // dfs
  int xLength = 0, yLength = 0;
  public int numIslands(char[][] grid) {
    if (grid.length < 1 || grid[0].length < 1) {
      return 0;
    }
    xLength = grid.length;
    yLength = grid[0].length;
    int ans = 0;
    for (int i = 0 ; i < xLength; i++) {
      for (int j = 0; j < yLength; j++) {
        if (grid[i][j] == '1') {
          ans++;
          dfs(grid, i, j);
        }
      }
    }
    return ans;
  }

  private void dfs(char[][] grid, int i, int j) {
    grid[i][j] = '0';
    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
      dfs(grid, i - 1, j);
    }
    if ( i + 1 < xLength && grid[i + 1][j] == '1') {
      dfs(grid, i + 1, j);
    }
    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
      dfs(grid, i, j-1);
    }
    if (j + 1 < yLength && grid[i][j + 1] == '1') {
      dfs(grid, i, j + 1);
    }
  }

  public int numIslands1(char[][] grid) {
    if (grid.length < 1 || grid[0].length < 1) {
      return 0;
    }
    int ans = 0;
    int[] f = new int[grid.length * grid[0].length];
    // 动态联通
    // 从左上往右下遍历，从2开始
    int curr = '2';
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          if (i - 1 >= 0) {
            if (grid[i - 1][j] > '1') {
              grid[i][j] = grid[i - 1][j];
            }
          }
          if (j - 1 >= 0) {
            if (grid[i][j - 1] > '1') {
              if (grid[i][j] > '1') {
                if (grid[i][j] != grid[i][j - 1]) {
                  if (union(f, grid[i][j], grid[i][j - 1])) {
                    ans--;
                  }
                }
              } else {
                grid[i][j] = grid[i][ j - 1];
              }
            }
          }
          if (grid[i][j] == '1') {
            f[curr - '2'] = curr - '2';
            ans++;
            grid[i][j] = (char)(curr++);
          }
        }
      }
    }
    return ans;
  }

  private boolean union(int[] arr, char a, char b) {
    int i1 = a - '2';
    int i2 = b - '2';
    int v1 = getVal(arr, i1);
    int v2 = getVal(arr, i2);
    if (v1 == v2) {
      return false;
    } else {
      arr[v1] = v2;
      return true;
    }
  }

  private int getVal(int[] arr, int i) {
    while (arr[i] != i) {
      i = arr[i];
    }
    return i;
  }
}
