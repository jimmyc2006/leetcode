package shuwei.leetcode.cn.seven.seven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  // 10ms 73%
  public List<List<Integer>> combine(int n, int k) {
    ans = new ArrayList<>();
    deal(n, k, 1, 0, new Integer[k]);
    return ans;
  }

  private List<List<Integer>> ans;

  private void deal(int n, int k, int start, int index, Integer[] tmp) {
    if (index == k) {
      ans.add(Arrays.asList(Arrays.copyOf(tmp, k)));
      return;
    }
    // 假设当前是第0个，最后几个选不了，因为后面不够到k的长度了
    // 公式：index + 剩余 >= k,当index是0的时候，max可以到倒数第k个;当index是1的时候，max能到倒数第k - 1个
    //
    int max = n - k + 1 + index;
    for (int i = start; i <= max; i++) {
      tmp[index] = i;
      deal(n, k, i + 1, index + 1, tmp);
    }
  }
}
