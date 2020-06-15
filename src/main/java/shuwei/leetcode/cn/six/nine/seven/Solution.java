package shuwei.leetcode.cn.six.nine.seven;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  public int findShortestSubArray(int[] nums) {
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
