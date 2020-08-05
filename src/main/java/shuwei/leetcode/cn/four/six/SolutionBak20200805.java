package shuwei.leetcode.cn.four.six;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionBak20200805 {
  
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> finalResult = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) {
      q.add(nums[i]);
    }
    int[] result = new int[nums.length];
    selectAll(q, result, finalResult);
    return finalResult;
  }
  
  private void selectAll(Queue<Integer> q, int[] result, List<List<Integer>> finalResult) {
    int size = q.size();
    if (size == 1) {
      result[result.length - size] = q.peek();
      List<Integer> list = new ArrayList<>(result.length);
      for (int i = 0; i < result.length; i++) {
        list.add(i, result[i]);
      }
      finalResult.add(list);
      return;
    }
    for (int i = 0; i < size; i++) {
      int tmp = q.poll();
      result[result.length - size] = tmp;
      selectAll(q, result, finalResult);
      q.add(tmp);
    }
  }
}
