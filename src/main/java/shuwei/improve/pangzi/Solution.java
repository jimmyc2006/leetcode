package shuwei.improve.pangzi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution(new int[]{1, 2, 3, 4, 5}, new int[]{10, 10, 10, 10, 10}, new int[]{4, 5, 6});
    System.out.println(s.select());
  }

  private int[] lengths;
  private int[] counts;
  private int[] goods;


  public Solution(int[] lengths, int[] counts, int[] goods) {
    this.lengths = lengths;
    this.counts = counts;
    this.goods = goods;
  }

  /**
   * 输入当前已经废弃的材料长度
   *
   * @return 最小的成本
   */
  public int select() {
    // 剩余的长度由一个商品能提供的情况
    int needLength = 0;
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] > 0) {
        needLength += lengths[i] * counts[i];
      }
    }
    if (needLength <= goods[goods.length - 1]) {
      if (needLength < goods[0]) {
        return goods[0] - needLength;
      } else {
        return 0;
      }
    }
    System.out.println("剩余:" + needLength);
    // 从待选列表中轮训来选择
    int minBad = Integer.MAX_VALUE;
    for (int i = 0; i < goods.length; i++) {
      // 可能选择的排列组合
      for (int[] selects : selectUser(goods[i])) {
        int remain = goods[i];
        for (int x = 0; x < selects.length; x++) {
          if (selects[x] != 0) {
            counts[x] = counts[x] - selects[x];
            remain = remain - lengths[x] * selects[x];
          }
        }
        int theWaste = remain;
        minBad = Math.min(minBad, theWaste + select());
        // 计算完成以后将数量加回来
        for (int x = 0; x < selects.length; x++) {
          if (selects[x] != 0) {
            counts[x] = counts[x] + selects[x];
          }
        }
      }
    }
    return minBad;
  }

  // 变成1种长度，切成几种的问题
  private List<int[]> selectUser(int good) {
    List<int[]> result = new ArrayList<>();
    selectOne(good, new int[lengths.length], result);
    System.out.println(good + "方案");
    for (int[] ele : result) {
      System.out.println(Arrays.toString(ele));
    }
    return result;
  }

  private void selectOne(int remain, int[] selected, List<int[]> result) {
    if (remain < lengths[0]) {
      result.add(Arrays.copyOf(selected, selected.length));
      return;
    }
    for (int i = 0; i < lengths.length; i++) {
      if (remain >= lengths[i] && counts[i] > 0) {
        selected[i]++;
        counts[i]--;
        selectOne(remain - lengths[i], selected, result);
        selected[i]--;
        counts[i]++;
      }
    }
  }
}
