package shuwei.leetcode.cn.one.zero.three.zero;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  // 枚举法
  public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
    int[][] ans = new int[R * C][2];
    int index = 0;
    ans[index++] = new int[]{r0, c0};
    for (int i = 1; index < R * C; i++) {
      for (int j = 0; j <= i; j++) {
        int x = r0 - j;
        if (x < 0) {
          break;
        }
        int yDiff = i - j;
        if (yDiff > 0) {
          int y = c0 - yDiff;
          if (y >= 0) {
            ans[index][0] = x;
            ans[index++][1] = y;
          }
          y = c0 + yDiff;
          if (y < C) {
            ans[index][0] = x;
            ans[index++][1] = y;
          }
        } else {
          ans[index][0] = x;
          ans[index++][1] = c0;
        }
      }
      for (int j = 1; j <= i; j++) {
        int x = r0 + j;
        if (x >= R) {
          break;
        }
        int yDiff = i - j;
        if (yDiff > 0) {
          int y = c0 - yDiff;
          if (y >= 0) {
            ans[index][0] = x;
            ans[index++][1] = y;
          }
          y = c0 + yDiff;
          if (y < C) {
            ans[index][0] = x;
            ans[index++][1] = y;
          }
        } else {
          ans[index][0] = x;
          ans[index++][1] = c0;
        }
      }
    }
    return ans;
  }

  /**
   * 看过答案后的桶排序算法
   * @param R
   * @param C
   * @param r0
   * @param c0
   * @return
   */
  public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
    // 假设R和C为10，r0为0，c0为0时候，10-0 + 10 - 0 = 20不对
    int maxDis = Math.max(r0, R - r0 - 1) + Math.max(c0, C - c0 - 1);
    List<int[]>[] bucks = new List[maxDis + 1];
    for (int i = 0; i < bucks.length; i++) {
      bucks[i] = new ArrayList<>();
    }
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        int dis = dis(r0, c0, i, j);
        bucks[dis].add(new int[]{i, j});
      }
    }
    int[][] ans = new int[R * C][2];
    int index = 0;
    for (int i = 0; i <= maxDis; i++) {
      for (int[] ele : bucks[i]) {
        ans[index++] = ele;
      }
    }
    return ans;
  }

  private int dis(int r0, int c0, int x, int y) {
    return Math.abs(r0 - x) + Math.abs(c0 - y);
  }
  /**
   * 创建一个数组，表示是否被访问过，然后使用广度优先
   * @param R
   * @param C
   * @param r0
   * @param c0
   * @return
   */
  public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
    boolean[][] isUsed = new boolean[R][C];
    int[][] ans = new int[R * C][2];
    List<int[]> list = new ArrayList<>();
    list.add(new int[]{r0, c0});
    isUsed[r0][c0] = true;
    int index = 0;
    ans[index++] = new int[]{r0, c0};
    while (list.size() > 0) {
      List<int[]> nextLevels = new ArrayList<>();
      for (int[] ele : list) {
        int x = ele[0];
        int y = ele[1];
        if (x - 1 >= 0 && !isUsed[x - 1][y]) {
          nextLevels.add(deal(x - 1, y, isUsed, ans, index++));
        }
        if (x + 1 < R && !isUsed[x + 1][y]) {
          nextLevels.add(deal(x + 1, y, isUsed, ans, index++));
        }
        if (y - 1 >= 0 && !isUsed[x][y - 1]) {
          nextLevels.add(deal(x, y - 1, isUsed, ans, index++));
        }
        if (y + 1 < C && !isUsed[x][y + 1]) {
          nextLevels.add(deal(x, y + 1, isUsed, ans, index++));
        }
      }
      list = nextLevels;
    }
    return ans;
  }

  private int[] deal(int x, int y, boolean[][] isUsed, int[][] ans, int index) {
    isUsed[x][y] = true;
    int[] newVal = new int[]{x, y};
    ans[index] = newVal;
    return newVal;
  }
}
