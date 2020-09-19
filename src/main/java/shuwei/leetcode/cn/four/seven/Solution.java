package shuwei.leetcode.cn.four.seven;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

  // 每个一步选择一个数，每一步不重复选择
  public List<List<Integer>> permuteUnique(int[] nums) {
    ans = new ArrayList<>();
    boolean[] status = new boolean[nums.length];
    select(nums, 0, status, new ArrayList<>());
    return ans;
  }

  private List<List<Integer>> ans;

  private void select(int[] nums, int level, boolean[] status, List<Integer> tmp) {
    if (level == nums.length) {
      ans.add(new ArrayList<>(tmp));
      return;
    }
    Set<Integer> used = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (status[i]) {
        continue;
      }
      if (used.add(nums[i])) {
        status[i] = true;
        tmp.add(nums[i]);
        select(nums, level + 1, status, tmp);
        tmp.remove(tmp.size() - 1);
        status[i] = false;
      }
    }
  }

}
