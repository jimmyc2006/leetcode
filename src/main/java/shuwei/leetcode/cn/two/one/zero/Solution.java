package shuwei.leetcode.cn.two.one.zero;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
  // 两步优化，第一步将需要的前置节点的数量改为用数组表示
  // 第二步将后续节点改为列表数组表示
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] result = new int[numCourses];
    int index = 0;
    Stack<Integer> stack = new Stack<>();
    // 保存每个数一共需要多少个前件
    int[] preCount = new int[numCourses];
    @SuppressWarnings("unchecked")
    List<Integer>[] nextList = new List[numCourses];
    for (int i = 0; i < numCourses; i++) {
      nextList[i] = new ArrayList<>();
    }
    for (int[] relation : prerequisites) {
      preCount[relation[0]]++;
      nextList[relation[1]].add(relation[0]);
    }
    for (int i = 0; i < numCourses; i++) {
      if (preCount[i] == 0) {
        stack.add(i);
      }
    }
    while (!stack.isEmpty()) {
      Integer num = stack.pop();
      result[index++] = num;
      for (Integer next : nextList[num]) {
        preCount[next]--;
        if (preCount[next] == 0) {
          stack.add(next);
        }
      }
    }
    if (index == numCourses) {
      return result;
    } else {
      return new int[0];
    }
  }
}
