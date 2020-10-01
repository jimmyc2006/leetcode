package shuwei.leetcode.one.zero.nine;

import shuwei.leetcode.cn.ListNode;
import shuwei.leetcode.cn.TreeNode;

public class Solution {
  // 中序遍历就是升序，如果直接建立空的TreeNode，然后使用中序遍历赋值，是否能解决问题？
  // 边建立树边计算节点，等数量够的时候就开始赋值,这个思路有问题
  // 换个思路，将链表的数值放在list中，然后取中间作为root，左边取中间作为左边节点，右边取中间作为右边节点
  // 依次类推
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }
    values = count(head);
    return gen(0, values.length);
  }

  private int[] values;

  private int[] count(ListNode head) {
    int count = 0;
    ListNode curr = head;
    while (curr != null) {
      count++;
      curr = curr.next;
    }
    int[] res = new int[count];
    curr = head;
    for (int i = 0 ; i < count; i ++) {
      res[i] = curr.val;
      curr = curr.next;
    }
    return res;
  }

  // 包含start，不包含end
  private TreeNode gen (int start, int end) {
    if (start == end) {
      return null;
    }
    int mid = start + (end - start) / 2;
    TreeNode node = new TreeNode(values[mid]);
    node.left = gen(start, mid);
    node.right = gen(mid + 1, end);
    return node;
  }

}
