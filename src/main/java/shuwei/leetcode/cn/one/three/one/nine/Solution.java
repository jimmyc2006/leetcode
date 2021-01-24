package shuwei.leetcode.cn.one.three.one.nine;

import shuwei.leetcode.cn.Uniform;

public class Solution {

  public int makeConnected(int n, int[][] connections) {
    Uniform uniform = new Uniform(n);
    // 多余的连接
    int more = 0;
    for (int[] ele : connections) {
      if (!uniform.union(ele[0], ele[1])) {
        more++;
      }
    }
    if (more >= uniform.getGroup() - 1) {
      return uniform.getGroup() - 1;
    }
    return -1;
  }
}
