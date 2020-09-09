package shuwei.leetcode.cn.three.nine;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  /**
   * 先采用排列的方式遍历, 5 ms
   * , 在所有 Java 提交中击败了
   * 42.85%
   * 的用户
   * 为了避免出现重复的数值，每次迭代都从上一层的当前位置开始
   * @param candidates
   * @param target
   * @return
   */
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    ans = new ArrayList<>();
    dfs(0, candidates, 0, target, new ArrayList<>());
    return ans;
  }

  private List<List<Integer>> ans;

  private void dfs(int start, int[] candidates, int current, int target, List<Integer> list) {
    if (current > target) {
      return ;
    } else if (current == target) {
      ans.add(new ArrayList<>(list));
    }
    for (int i = start; i < candidates.length; i++) {
      list.add(candidates[i]);
      dfs(i, candidates, current + candidates[i], target, list);
      list.remove(list.size() - 1);
    }
  }
}
