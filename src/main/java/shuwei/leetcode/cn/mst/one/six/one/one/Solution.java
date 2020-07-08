package shuwei.leetcode.cn.mst.one.six.one.one;

public class Solution {

  public int[] divingBoard(int shorter, int longer, int k) {
    if (k == 0) {
      return new int[0];
    }
    if (shorter == longer) {
      return new int[]{longer * k};
    }
    int[] ans = new int[k + 1];
    for (int i = 0; i <= k; i++) {
      ans[i] = (k - i) * shorter + i * longer;
    }
    return ans;
  }

}
