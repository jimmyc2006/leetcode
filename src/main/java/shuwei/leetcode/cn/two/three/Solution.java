package shuwei.leetcode.cn.two.three;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

public class Solution {
  
  public ListNode mergeKLists(ListNode[] lists) {
    boolean isEmpty = true;
    if (lists == null || lists.length < 1) {
      return null;
    }
    for (ListNode ln : lists) {
      if (ln != null) {
        isEmpty = false;
        break;
      }
    }
    if (isEmpty) {
      return null;
    }
    // 保存数值对应的列表的序列号
    TreeSet<Integer>  tree = new TreeSet<>();
    // 存放重复的值
    Map<Integer, Queue<Integer>> repeat = new HashMap<>();
    for (int i = 0; i< lists.length; i++) {
      ListNode tmp = lists[i];
      if (tmp == null) {
        continue;
      }
      tree.add(tmp.val);
      Queue<Integer> queue = repeat.get(tmp.val);
      if (queue == null) {
        queue = new LinkedList<>();
        repeat.put(tmp.val, queue);
      }
      queue.add(i);
    }
    Integer firstVal = tree.pollFirst();
    ListNode root = new ListNode(firstVal);
    ListNode curr = root;
    Queue<Integer> q = repeat.get(firstVal);
    boolean isFirst = true;
    while (!q.isEmpty()) {
      int index = q.poll();
      if (!isFirst) {
        ListNode n = new ListNode(firstVal);
        curr.next = n;
        curr = n;
      } else {
        isFirst = false;
      }
      this.dealNext(lists, index, tree, repeat);
    }
    while(!tree.isEmpty()) {
      firstVal = tree.pollFirst();
      Queue<Integer> queue = repeat.get(firstVal);
      while (!queue.isEmpty()) {
        Integer t = queue.poll();
        ListNode n = new ListNode(firstVal);
        curr.next = n;
        curr = n;
        this.dealNext(lists, t, tree, repeat);
      }
    }
    return root; 
  }
  
  private void dealNext(ListNode[] lists, int i, TreeSet<Integer> tree, Map<Integer, Queue<Integer>> repeat) {
    lists[i] = lists[i].next;
    if (lists[i] != null) {
      int val = lists[i].val;
      tree.add(val);
      Queue<Integer> queue = repeat.get(val);
      if (queue == null) {
        queue = new LinkedList<>();
        repeat.put(val, queue);
      }
      queue.add(i);
    }
  }
}
