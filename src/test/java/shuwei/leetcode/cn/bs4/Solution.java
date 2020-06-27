package shuwei.leetcode.cn.bs4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

  public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
    Map<Integer, Set<Integer>> beforeMap = new HashMap<>();
    for (int[] rela : dependencies) {
      Set<Integer> befores = beforeMap.compute(rela[1], k -> new HashSet<>());
      befores.add(rela[0]);
    }
    List<List<Integer>> steps = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      
    }
  }
}
