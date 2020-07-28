package shuwei.leetcode.cn.one.four.nine.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

  public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
    afterMap.clear();
    beforeMap.clear();
    this.n = n;
    this.k = k;
    for (int[] ele : dependencies) {
      Set<Integer> afters = afterMap.computeIfAbsent(ele[0], key -> new HashSet<>());
      afters.add(ele[1]);
      Set<Integer> befores = beforeMap.computeIfAbsent(ele[1], key -> new HashSet<>());
      befores.add(ele[0]);
    }
    // 不使用0
    int[] statusArr = new int[n + 1];
    int aloneCount = 0;
    // 初始化状态数组和独立个数
    for (int i = 1; i <= n; i++) {
      Set<Integer> integers = beforeMap.get(i);
      if (integers == null) {
        if (afterMap.get(i) == null) {
          aloneCount++;
          statusArr[i] = -1;
        } else {
          statusArr[i] = 0;
        }
      } else {
        statusArr[i] = integers.size();
      }
    }
    return select(statusArr, aloneCount);
  }

  Map<Integer, Set<Integer>> afterMap = new HashMap<>();
  Map<Integer, Set<Integer>> beforeMap = new HashMap<>();
  private int k = 0;
  private int n = 0;

  // 返回需要的学期数
  private int select(int[] statusArr, int aloneCount) {
    // 当前可选择的成员
    List<Integer> thisSelects = new ArrayList<>();
    // 剩余的数量
    int remainCount = 0;
    for (int i = 1; i < statusArr.length; i++) {
      if (statusArr[i] == 0) {
        thisSelects.add(i);
      } else if (statusArr[i] > 0) {
        remainCount++;
      }
    }
    // 如果没有需要前置的
    if (remainCount == 0) {
      int allRemain = thisSelects.size() + Math.max(aloneCount, 0);
      return allRemain % k == 0 ? allRemain / k: allRemain / k + 1;
    }
    // 如果有后续任务的数量小于等于k
    if (thisSelects.size() <= k) {
      int[] newStatus = copy(statusArr);
      for (int i = 1; i < statusArr.length; i++) {
        if (statusArr[i] == 0) {
          newStatus[i] = -1;
          Set<Integer> afters = afterMap.get(i);
          if (afters != null) {
            for (Integer af : afters) {
              newStatus[af]--;
            }
          }
        }
      }
      int next = this.select(newStatus, aloneCount - (k - thisSelects.size()));
      return 1 + next;
    } else {
      // k不够的情况,排列组合
      List<int[]> coms = new ArrayList<>();
      comInner(thisSelects, new int[k], 0, 0, coms);
      int minStep = Integer.MAX_VALUE;
      for (int[] ele : coms) {
        int[] newStatus = copy(statusArr);
        for (int i : ele) {
          // 第i 个被选择
          newStatus[i] = -1;
          Set<Integer> after = afterMap.get(i);
          if (after != null) {
            for (Integer iT : after) {
              newStatus[iT]--;
            }
          }
        }
        minStep = Math.min(minStep, select(newStatus, aloneCount));
      }
      return minStep + 1;
    }
  }


  // 从selects中选择k个的排列组合
  private void comInner(List<Integer> selects, int[] res, int index, int selectIndex, List<int[]> result) {
    if (index == res.length) {
      result.add(Arrays.copyOfRange(res, 0, k));
      return;
    }
    for (int i = selectIndex; i < selects.size() && selects.size() - i >= res.length - index; i++) {
      res[index] = selects.get(i);
      comInner(selects, res, index + 1, i + 1, result);
    }
  }

  private int[] copy(int[] src) {
    int[] result = new int[src.length];
    for (int i = 1; i < src.length; i++) {
      result[i] = src[i];
    }
    return result;
  }
}
