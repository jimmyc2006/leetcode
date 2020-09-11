package shuwei.leetcode.cn.four.zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  // 采用开头已经处理过的就直接挑过去
  // 5ms 45%
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> ans = new ArrayList<>();
    deal(candidates, 0, 0, target, ans, new ArrayList<>());
    return ans;
  }

  private void deal(int[] candidates, int start, int curr, int target, List<List<Integer>> ans, List<Integer> list) {
    if (curr == target) {
      ans.add(new ArrayList<>(list));
    } else if (curr > target) {
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      if (i - 1 >= start && candidates[i] == candidates[i - 1]) {
        continue;
      }
      list.add(candidates[i]);
      deal(candidates, i + 1, curr + candidates[i], target, ans, list);
      list.remove(list.size() - 1);
    }
  }

}
