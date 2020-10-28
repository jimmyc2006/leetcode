package shuwei.leetcode.cn.one.two.zero.seven;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  public boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> counts = new HashMap<>();
    for (int ele : arr) {
      Integer curr = counts.get(ele);
      if (curr == null) {
          counts.put(ele, 1);
      } else {
        counts.put(ele, curr + 1);
      }
    }
    Set<Integer> has = new HashSet<>();
    for (Integer ele : counts.values()) {
      if (!has.add(ele)) {
        return false;
      }
    }
    return true;
  }

}
