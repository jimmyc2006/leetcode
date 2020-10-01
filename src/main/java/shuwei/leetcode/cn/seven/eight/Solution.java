package shuwei.leetcode.cn.seven.eight;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  /**
   *
   * 每个数都包含选择和不选
   * @param nums
   * @return
   */
  public List<List<Integer>> subsets(int[] nums) {
    ans = new ArrayList<>();
    select(nums, 0, new ArrayList<>());
    return ans;
  }

  List<List<Integer>> ans;

  private void select (int[] nums, int index, List<Integer> tmpRes) {
    if (index == nums.length) {
      ans.add(new ArrayList<>(tmpRes));
      return;
    }
    // 不选择这个数
    select(nums, index + 1, tmpRes);
    // 选择这个数
    tmpRes.add(nums[index]);
    select(nums, index + 1, tmpRes);
    tmpRes.remove(tmpRes.size() - 1);
  }
}
