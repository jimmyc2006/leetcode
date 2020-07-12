package shuwei.leetcode.cn.one.seven.four;

import java.util.Arrays;

public class Solution {
  // 这个题求的是能到达终点的初始最低生命值，不是中途需要的最高生命值
  // 从前往后做dp，会出现即需要保留当前和，也需要保存当前最低生命值的情况，下一步不是一来前面一步，而是具体一来前面的几种数值
  // 所以无法用从前往后做dp来解答此题
  // 从后往前做dp的时候只要 保证每一步都活着，不用保存累计值
  // 理论上某一步就是它后面两种走法需要的最低生命值，在结合当前步骤数值，就能计算出当前步骤需要的最低生命值
  public int calculateMinimumHP(int[][] dungeon) {
    int xLength = dungeon.length;
    int yLength = dungeon[0].length;
    int[][] f = new int[xLength + 1][yLength + 1];
    for (int i = 0; i <= xLength; i++) {
      Arrays.fill(f[i], Integer.MAX_VALUE);
    }
    // 最后一个点的下面和右边设置为1
    f[xLength - 1][yLength] = 1;
    f[xLength][yLength - 1] = 1;
    for(int i = xLength - 1; i >= 0; i--) {
      for (int j = yLength - 1; j >= 0; j--) {
        int min = Math.min(f[i + 1][j], f[i][j + 1]);
        f[i][j] = Math.max(min - dungeon[i][j], 1);
      }
    }
    return f[0][0];
  }
}
