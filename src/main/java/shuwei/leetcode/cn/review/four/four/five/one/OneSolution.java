package shuwei.leetcode.cn.review.four.four.five.one;

import java.util.HashMap;
import java.util.Map;

public class OneSolution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      Integer had = map.get(target - nums[i]);
      if (had != null) {
        return new int[]{had, i};
      } else {
        map.put(nums[i], i);
      }
    }
    return null;
  }
}
