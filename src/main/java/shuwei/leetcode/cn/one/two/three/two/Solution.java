package shuwei.leetcode.cn.one.two.three.two;

public class Solution {
  public boolean checkStraightLine(int[][] coordinates) {
    if (coordinates[1][0] == coordinates[0][0]) {
      return checkAllEquals(coordinates, 0);
    }
    if (coordinates[1][1] == coordinates[0][1]) {
      return checkAllEquals(coordinates, 1);
    }
    int a = coordinates[1][0] - coordinates[0][0];
    int b = coordinates[1][1] - coordinates[0][1];
    for (int i = 2; i < coordinates.length; i++) {
      if ((coordinates[i][0] - coordinates[0][0]) * b != a * (coordinates[i][1] - coordinates[0][1])) {
        return false;
      }
    }
    return true;
  }

  private boolean checkAllEquals(int[][] coord, int index) {
    int val = coord[0][index];
    for (int i = 1; i < coord.length; i++) {
      if (val != coord[i][index]) {
        return false;
      }
    }
    return true;
  }
}
