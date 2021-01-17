//package shuwei.leetcode.cn.one.two.zero.three;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class Solution {
//
//  /**
//   *
//   * 先判断n个项目之间是否有循环依赖，如果有直接返回
//   * 将项目分配到每个组中，如果遇到矛盾，就尝试重新选择
//   * @param n
//   * @param m
//   * @param group
//   * @param beforeItems
//   * @return
//   */
//  public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
//    // 表示某个任务的所有上游任务
//    List<Set<Integer>> beforeItemAll = new ArrayList<>(n);
//    for (int i = 0 ; i < n; i++) {
//      List<Integer> pres = beforeItems.get(i);
//      if (pres.size() > 0) {
//        Set<Integer> presAll = findPres(beforeItems, i);
//        if (presAll == null) {
//          return new int[]{};
//        } else {
//          beforeItemAll.add(presAll);
//        }
//      } else {
//        beforeItemAll.add(new HashSet<>());
//      }
//    }
//    // 尝试将任务分配给小组
//    List<Set<Integer>> groupTasks = new ArrayList<>(n);
//    for (int i = 0; i < n; i++) {
//      Set<Integer> set = new HashSet<>();
//      groupTasks.add(set);
//      if (group[i] >= 0) {
//        set.add(group[i]);
//      }
//    }
//    // 组的依赖关系
//    List<Set<Integer>> groupPres = new ArrayList<>(m);
//
//    // 遍历所有任务，选择一个小组分配
//    for (int i = 0; i < n; i++) {
//      // 先查看是否有组
//      int groupId = group[i];
//      Set<Integer> allBefore = beforeItemAll.get(i);
//      Set<Integer> allBeforeGroup = new HashSet<>();
//      for (Integer bef : allBefore) {
//        if (group[bef] >= 0 ) {
//          allBeforeGroup.add(group[bef]);
//        }
//      }
//
//    }
//  }
//
//  // 判断是否有环状依赖
//  private Set<Integer> findPres(List<List<Integer>> beforeItems, int curr) {
//    Set<Integer> ans = new HashSet<>();
//    Set<Integer> presSet = new HashSet<>(beforeItems.get(curr));
//    while (presSet.size() > 0) {
//      Set<Integer> ns = new HashSet<>();
//      for (Integer pre : presSet) {
//        if (ans.contains(pre)) {
//          return null;
//        }
//        ans.add(pre);
//        ns.addAll(beforeItems.get(pre));
//      }
//      presSet = ns;
//    }
//    return ans;
//  }
//
//}
