package shuwei.leetcode.cn.two.three;

import java.util.*;

import shuwei.leetcode.cn.ListNode;

public class Solution {
  // 5ms 60+%
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length < 1) {
      return null;
    }
    ListNode ans = null, curr = null;
    PriorityQueue<ListNode> queue = new PriorityQueue(lists.length, new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
      }
    });
    for (ListNode ln : lists) {
      if (ln != null) {
        queue.add(ln);
      }
    }
    while (!queue.isEmpty()){
      ListNode ln = queue.poll();
      if (ans == null) {
        ans = ln;
        curr = ln;
      } else {
        curr.next = ln;
        curr = ln;
      }
      if (ln.next != null) {
        queue.add(ln.next);
      }
    }
    return ans;
  }

  // -------- 6.1复习,6ms,57%
  public ListNode mergeKLists2(ListNode[] lists) {
    if (lists == null || lists.length < 1) {
      return null;
    }
    TreeMap<Integer, List<Integer>> sortAndIndexs = new TreeMap<>();
    for (int i = 0; i < lists.length; i++) {
      add(sortAndIndexs, lists[i], i);
    }
    ListNode root = null;
    ListNode curr = null;
    while (!sortAndIndexs.isEmpty()) {
      Map.Entry<Integer, List<Integer>> integerListEntry = sortAndIndexs.pollFirstEntry();
      for (int index : integerListEntry.getValue()) {
        if (root == null) {
          root = lists[index];
          curr = root;
        } else {
          curr.next = lists[index];
          curr = curr.next;
        }
        lists[index] = lists[index].next;
        if (lists[index] != null) {
          add(sortAndIndexs, lists[index], index);
        }
      }
    }
    if (curr != null) {
      curr.next = null;
    }
    return root;
  }

  private void add(TreeMap<Integer, List<Integer>> sortAndIndexs, ListNode ln, int i) {
    if (ln == null) {
      return;
    }
    List<Integer> indexs = sortAndIndexs.get(ln.val);
    if (indexs == null) {
      indexs = new ArrayList<>();
      sortAndIndexs.put(ln.val, indexs);
    }
    indexs.add(i);
  }
  // -------- 6.1复习

  // 10ms
  public ListNode mergeKLists1(ListNode[] lists) {
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
    TreeSet<Integer> tree = new TreeSet<>();
    // 存放重复的值
    Map<Integer, Queue<Integer>> repeat = new HashMap<>();
    for (int i = 0; i < lists.length; i++) {
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
    while (!tree.isEmpty()) {
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
