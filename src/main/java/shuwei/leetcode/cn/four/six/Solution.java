package shuwei.leetcode.cn.four.six;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  // 这个是求排列情况
  public List<List<Integer>> permute(int[] nums) {
    if (nums == null) {
      return null;
    }
    status = new int[nums.length];
    ans = new ArrayList<>();
    allRage(nums, new ArrayList<>(nums.length));
    return ans;
  }

  int[] status;
  List<List<Integer>> ans;
  private void allRage(int[] nums, ArrayList<Integer> tmpAns) {
    for (int i = 0; i < nums.length; i++) {
      if (status[i] == 0) {
        tmpAns.add(nums[i]);
        if (tmpAns.size() == nums.length) {
          ans.add(new ArrayList<>(tmpAns));
        } else {
          status[i] = 1;
          allRage(nums, tmpAns);
          status[i] = 0;
        }
        tmpAns.remove(tmpAns.size() - 1);
      }
    }
  }
}
