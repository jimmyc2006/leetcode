package shuwei.leetcode.cn.four.five.six;

import java.util.TreeSet;

public class Solution {

  public boolean find132pattern(int[] nums) {
    TreeSet<Integer> treeSet = new TreeSet<>();
    int curr = Integer.MIN_VALUE;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] < curr) {
        return true;
      }
      Integer floor = treeSet.floor(nums[i] - 1);
      if (floor != null) {
        curr = Math.max(curr, floor);
      }
      treeSet.add(nums[i]);
    }
    return false;
  }

}
