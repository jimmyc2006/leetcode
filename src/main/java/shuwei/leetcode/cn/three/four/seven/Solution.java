package shuwei.leetcode.cn.three.four.seven;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
  /**
   *
   * @param nums
   * @param k
   * @return
   */
  public int[] topKFrequent(int[] nums, int k) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int count = 1;
    int i = 1;
    for (; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        map.put(count, nums[i - 1]);
        count = 1;
      } else {
        count++;
      }
    }
    if (count > 0) {
      map.put(count, nums[i - 1]);
    }
    int[] ans = new int[k];
    while (k > 0) {
      Map.Entry<Integer, Integer> integerIntegerEntry = map.pollLastEntry();
      ans[k - 1] = integerIntegerEntry.getValue();
      k--;
    }
    return ans;
  }
}
