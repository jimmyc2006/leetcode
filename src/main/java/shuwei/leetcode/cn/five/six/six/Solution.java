package shuwei.leetcode.cn.five.six.six;

public class Solution {

  public int[][] matrixReshape(int[][] nums, int r, int c) {
    if (nums.length * nums[0].length != r * c) {
      return nums;
    }
    int[][] ans = new int[r][c];
    int x = 0, y = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums[i].length; j++) {
        ans[x][y++] = nums[i][j];
        if (y == c) {
          x++;
          y = 0;
        }
      }
    }
    return ans;
  }
}
