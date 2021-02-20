package shuwei.leetcode.cn.six.nine.seven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
  /**
   * 20210220第二次
   * @param nums
   * @return
   */
  public int findShortestSubArray(int[] nums) {
    int[] counts = new int[50000];
    int[] starts = new int[50000];
    int[] ends = new int[50000];
    int max = 0;
    List<Integer> maxIndexs = new ArrayList<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      counts[nums[i]]++;
      if (counts[nums[i]] == 1) {
        starts[nums[i]] = i;
      }
      if (counts[nums[i]] > max) {
        max = counts[nums[i]];
        maxIndexs.clear();
        maxIndexs.add(nums[i]);
        ends[nums[i]] = i;
      } else if (counts[nums[i]] == max) {
        maxIndexs.add(nums[i]);
        ends[nums[i]] = i;
      }
    }
    int ans = nums.length;
    for (Integer maxIndex : maxIndexs) {
      ans = Math.min(ends[maxIndex] - starts[maxIndex] + 1, ans);
    }
    return ans;
  }
  public int findShortestSubArray1(int[] nums) {
    Map<Integer, int[]> map = new HashMap<>();
    int max = 0;
    Set<Integer> maxNums = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      int[] val = map.computeIfAbsent(nums[i], k -> new int[3]);
      if (val[0] == 0) {
        val[1] = i;
      }
      val[2] = i + 1;
      val[0] ++;
      if (val[0] > max) {
        max = val[0];
        maxNums = new HashSet<>();
        maxNums.add(nums[i]);
      } else if(val[0] == max) {
        maxNums.add(nums[i]);
      }
    }
    int ans = Integer.MAX_VALUE;
    for (int val : maxNums) {
      int[] info = map.get(val);
      ans = Math.min(ans, info[2] - info[1]);
    }
    return ans;
  }
}
