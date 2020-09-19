package shuwei.improve.pangzi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    int[] tar = new int[65 - 35 + 1];
    for (int i = 35; i <= 65; i++) {
      tar[i-35] = i;
    }
    Solution s = new Solution(new int[]{10, 12, 13}, new int[]{100, 50, 60}, tar);
    System.out.println("最有方案浪费材料:" + s.select(true));
    s.printFangan();
    System.out.println(System.currentTimeMillis() - start);
  }

  private int[] lengths;
  private int[] counts;
  private int[] goods;
  private Map<String, Integer> cacheMin;
  private Map<String, String> data; // 保存最小耗材时候的选材和拆分情况

  public Solution(int[] lengths, int[] counts, int[] goods) {
    this.lengths = lengths;
    this.counts = counts;
    this.goods = goods;
    cacheMin = new HashMap<>();
    data = new HashMap<>();
  }

  /**select
   * 输入当前已经废弃的材料长度
   * @return 最小的成本
   */
  public int select(boolean isRoot) {
    // 剩余的长度由一个商品能提供的情况
    int needLength = 0;
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] > 0) {
        needLength += lengths[i] * counts[i];
      }
    }
    if (needLength <= goods[goods.length - 1]) {
      if (needLength < goods[0]) {
        data.put(this.getKey(this.counts), goods[0] + ":" + this.getKey(this.counts));
        return goods[0] - needLength;
      } else {
        data.put(this.getKey(this.counts), needLength + ":" + this.getKey(this.counts));
        return 0;
      }
    }
    String countsKey = getKey(counts);
    if (cacheMin.get(countsKey) != null) {
      return cacheMin.get(countsKey);
    }
    // 从待选列表中轮训来选择
    int minBad = Integer.MAX_VALUE;
    int bestGood = 0;
    int[] bestSelects = null;
    Set<String> fangans = new HashSet<>();
    for (int i = 0; i < goods.length; i++) {
      // 可能选择的排列组合
      for (int[] selects : selectFangan(goods[i])) {
        String key = getKey(selects);
        if (fangans.contains(key)) {
          continue;
        } else {
          fangans.add(key);
        }
        int remain = goods[i];
        for (int x = 0; x < selects.length; x++) {
          if (selects[x] != 0) {
            counts[x] = counts[x] - selects[x];
            remain = remain - lengths[x] * selects[x];
          }
        }
        int theWaste = remain;
        int thisBad = theWaste + select(false);
        if (thisBad < minBad) {
          minBad = thisBad;
          bestGood = goods[i];
          bestSelects = selects;
        }
        // 计算完成以后将数量加回来
        for (int x = 0; x < selects.length; x++) {
          if (selects[x] != 0) {
            counts[x] = counts[x] + selects[x];
          }
        }
        // 第一层如果算出来0了，就不继续处理
        if (isRoot && minBad == 0) {
          data.put(countsKey, bestGood + ":" + this.getKey(bestSelects));
          return 0;
        }
      }
    }
    cacheMin.put(countsKey, minBad);
    data.put(countsKey, bestGood + ":" + this.getKey(bestSelects));
    return minBad;
  }

  private void printFangan() {
    String key = this.getKey(this.counts);
    String s = data.get(key);
    if (s == null) {
      return;
    }
    String[] split = s.split(":");
    System.out.println("将" + split[0] + "拆分成:" + split[1]);
    String[] split2 = split[1].split(",");
    for (int i = 0; i < split2.length; i++) {
      counts[i] = counts[i] - Integer.parseInt(split2[i]);
    }
    printFangan();
  }

  // 变成1种长度，切成几种的问题
  // 如果大的选材的方案跟小的选材的方案一样的话，可以直接跳过，因为它不可能比小的节省
  private Set<int[]> selectFangan(int good) {
    Set<int[]> result = new HashSet<>();
    selectOne(good, new int[lengths.length], result);
    return result;
  }

  private void selectOne(int remain, int[] selected, Set<int[]> result) {
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

  private String getKey(int[] selectCounts) {
    StringBuilder sb = new StringBuilder();
    for (int ele : selectCounts) {
      sb.append(ele + ",");
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

}
