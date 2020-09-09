package shuwei.leetcode.cn.three.four.seven;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  /**
   * 使用Map计算每个数的个数，然后根据value排序，再寻找前k个值
   *执行用时：
   * 14 ms
   * , 在所有 Java 提交中击败了
   * 91.46%
   * 的用户
   * @param nums
   * @param k
   * @return
   */
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> data = new HashMap<>();
    for (int ele : nums) {
      Integer count = data.get(ele);
      if (count == null) {
        count = 1;
      } else {
        count++;
      }
      data.put(ele, count);
    }
    int index = 0;
    int[] counts = new int[data.size()];
    for (int ele : data.values()) {
      counts[index++] = ele;
    }
    Arrays.sort(counts);
    int level = counts[counts.length - k];
    int[] ans = new int[k];
    index = 0;
    for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
      if (entry.getValue() >= level) {
        ans[index++] = entry.getKey();
      }
    }
    return ans;
  }
}
