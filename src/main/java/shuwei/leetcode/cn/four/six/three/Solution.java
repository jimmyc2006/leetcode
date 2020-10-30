package shuwei.leetcode.cn.four.six.three;

public class Solution {

  /**
   * 遍历每一个方框，检查4个方向
   * @param grid
   * @return
   */
  public int islandPerimeter(int[][] grid) {
    int ans = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          ans += score(i, j, grid);
        }
      }
    }
    return ans;
  }

  private int score(int x, int y, int[][] grid) {
    int result = 4;
    // up
    if (y - 1 >= 0 && grid[x][y - 1] == 1) {
      result--;
    }
    // down
    if (y + 1 < grid[x].length && grid[x][y + 1] == 1) {
      result--;
    }
    // left
    if (x - 1 >= 0 && grid[x - 1][y] == 1) {
      result--;
    }
    if (x + 1 < grid.length && grid[x + 1][y] == 1) {
      result--;
    }
    return result;
  }

}
