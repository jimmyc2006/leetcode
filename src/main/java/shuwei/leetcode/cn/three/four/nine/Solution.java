package shuwei.leetcode.cn.three.four.nine;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<>();
    for (int ele : nums1) {
      set.add(ele);
    }
    Set<Integer> ans = new HashSet<>();
    for (int ele : nums2) {
      if (set.contains(ele)) {
        ans.add(ele);
      }
    }
    int [] res = new int[ans.size()];
    int index = 0;
    for (Integer ele : ans) {
      res[index++] = ele;
    }
    return res;
  }
}
