package shuwei.leetcode.cn.six.three.two;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

  public int[] smallestRange(List<List<Integer>> nums) {
    int length = nums.size();
    int[] ans = new int[2];
    int minLen = Integer.MAX_VALUE;
    // 0当前值，1list一层索引，2list二层索引
    PriorityQueue<int[]> queue = new PriorityQueue<>(length, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });
    int currMax = Integer.MIN_VALUE;
    for (int i =0; i < nums.size(); i++ ) {
      int v = nums.get(i).get(0);
      currMax = Math.max(currMax, v);
      queue.add(new int[] {v, i, 0});
    }
    while (queue.size() == length) {
      int[] minArr = queue.poll();
      int currMin = minArr[0];
      int diff = currMax - currMin;
      if (diff < minLen) {
        minLen = diff;
        ans[0] = currMin;
        ans[1] = currMax;
      }
      List<Integer> minList = nums.get(minArr[1]);
      int nextIndex = minArr[2] + 1;
      if (nextIndex < minList.size()) {
        int nextV = minList.get(nextIndex);
        queue.add(new int[]{nextV, minArr[1], nextIndex});
        currMax = Math.max(currMax, nextV);
      }
    }
    return ans;
  }
}
