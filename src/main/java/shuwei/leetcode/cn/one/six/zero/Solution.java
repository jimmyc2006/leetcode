package shuwei.leetcode.cn.one.six.zero;

import shuwei.leetcode.cn.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode curr = headA;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }
        curr = headB;
        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }
}
