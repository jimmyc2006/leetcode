package shuwei.leetcode.cn.one.one.two.eight;

public class Solution {

  /**
   * 每张牌按照数值从小到大的排序，二维数组中
   * @param dominoes
   * @return
   */
  public int numEquivDominoPairs(int[][] dominoes) {
    int length = dominoes.length;
    int[][] data = new int[10][10];
    int ans = 0;
    for (int[] ele : dominoes) {
      if (ele[1] < ele[0] ) {
        int tmp = ele[1];
        ele[1] = ele[0];
        ele[0] = tmp;
      }
      if (data[ele[0]][ele[1]] >= 1) {
        ans += data[ele[0]][ele[1]];
      }
      data[ele[0]][ele[1]]++;
    }
    return ans;
  }
}
