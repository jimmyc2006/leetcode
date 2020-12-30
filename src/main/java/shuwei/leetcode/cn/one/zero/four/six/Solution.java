package shuwei.leetcode.cn.one.zero.four.six;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    for (int ele : stones) {
      priorityQueue.add(ele);
    }
    while (priorityQueue.size() > 1) {
      int max = priorityQueue.poll();
      int second = priorityQueue.poll();
      priorityQueue.add(max - second);
    }
    return priorityQueue.poll();
  }
}
