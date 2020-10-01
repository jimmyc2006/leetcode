package shuwei.leetcode.cn.two.one.six;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<List<Integer>> combinationSum3(int k, int n) {
    ans = new ArrayList<>();
    deal(9, 1, k, n, new ArrayList<>(k), 0);
    return ans;
  }

  private List<List<Integer>> ans;

  private void deal(int max, int start, int k, int target, List<Integer> list, int curr) {
    if (k == 0) {
      if (curr == target) {
        ans.add(new ArrayList<>(list));
      }
      return;
    }
    if (curr >= target) {
      return;
    }
    for (int i = start; i <= max; i++) {
      list.add(i);
      deal(max, i + 1, k - 1, target, list, curr + i);
      list.remove(list.size() - 1);
    }
  }

}
