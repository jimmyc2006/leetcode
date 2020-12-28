package shuwei.leetcode.cn.one.eight.eight;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  /**
   * 先将每个位置买入，再后面任何位置卖出的收益计算出来 然后暴力遍历试试 超时，为了避免重复计算，可以采用从后往前算： 每个位置都计算1-k次交易的最大收益
   * 然后再往前算的时候，就可以使用到已经算完的结果了
   * 这个思路刚好能ac
   */
  public int maxProfit(int k, int[] prices) {
    this.k = k;
    this.prices = prices;
    this.length = prices.length;
    if (length <= 1 || k <= 0) {
      return 0;
    }
    ans = 0;
    curr = 0;
    earnIndexs = new List[length];
    maxProfile = new int[length][k + 1];
    for (int i = 0; i < length; i++) {
      earnIndexs[i] = new ArrayList<>();
      for (int j = i + 1; j < length; j++) {
        if (prices[j] > prices[i]) {
          earnIndexs[i].add(j);
        }
      }
    }
    for (int i = length - 2; i >= 0; i--) {
      profit(i);
    }
    return maxProfile[0][k - 1];
  }

  private int k;
  private int length;
  private int[] prices;
  private List<Integer>[] earnIndexs;
  private int curr;
  private int ans;
  private int[][] maxProfile; // 小表为0表示交易1次的最大收益，依此类推

  // 求某一个位置开始，到最后的0-k次的收益
  private void profit(int start) {
    for (int ct = 0; ct < k; ct++) {
      maxProfile[start][ct] = maxProfile[start + 1][ct];
      for (Integer earIndex : earnIndexs[start]) {
        if (ct > 0 && earIndex < length - 1) {
          maxProfile[start][ct] = Math.max(maxProfile[start][ct], prices[earIndex] - prices[start] + maxProfile[earIndex + 1][ct -1]);
        } else {
          maxProfile[start][ct] = Math.max(maxProfile[start][ct], prices[earIndex] - prices[start]);
        }
      }
    }
  }
}
