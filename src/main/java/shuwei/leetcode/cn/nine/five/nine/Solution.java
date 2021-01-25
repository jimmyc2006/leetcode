package shuwei.leetcode.cn.nine.five.nine;

import shuwei.leetcode.cn.Uniform;

public class Solution {

  /**
   * 将一个格子分为2个，使用动态连通性 每个点查看下面的格子和右边的格子的连通情况
   *
   * @param grid
   * @return
   */
  private static final char SPACE = ' ';
  private static final char LEFT = '/';

  public int regionsBySlashes(String[] grid) {
    int length = grid.length;
    Uniform uniform = new Uniform(length * length * 2);
    for (int i = 0; i < length; i++) {
      char[] chars = grid[i].toCharArray();
      for (int j = 0; j < length; j++) {
        /**
         * 计算方法:
         * 第0个是0，1;第1个是2,3;
         * 第2个是4,5;第3个是6,7
         * 每个是序号*2,到序号*2+1
         */
        int up = (i * length + j) * 2;
        int down = up + 1;
        // 右边
        if (chars[j] == SPACE) {
          uniform.union(up, down);
        }
        if (j + 1 < length) {
          if (chars[j] == SPACE) {
            // 如果右边是/那么其中一块与右边的up相连
            if (chars[j + 1] == LEFT) {
              uniform.union(down, down + 1);
            } else {
              uniform.union(down, down + 2);
            }
            // 如果右边是\的话，那么其中一块与右边的down相连
          } else if (chars[j] == LEFT) {
            if (chars[j + 1] == LEFT) {
              uniform.union(down, down + 1);
            } else {
              uniform.union(down, down + 2);
            }
          } else {
            if (chars[j + 1] == LEFT) {
              uniform.union(up, down + 1);
            } else {
              uniform.union(up, down + 2);
            }
          }
        }
        // 如果下面有格子，那么当前格子的下边的三角必然与下面格子的上面连接
        if (i + 1 < length) {
          int downUp = ((i + 1) * length + j) * 2;
          uniform.union(down, downUp);
        }
      }
    }
    return uniform.getGroup();
  }
}
