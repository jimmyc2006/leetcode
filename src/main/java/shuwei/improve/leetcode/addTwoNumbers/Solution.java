package shuwei.improve.leetcode.addTwoNumbers;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int over = 0;
        ListNode head = null;
        ListNode last = null;
        while(l1 != null || l2 != null || over == 1) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + over;
            if(sum >= 10) {
                over = 1;
                sum = sum % 10;
            } else {
                over = 0;
            }
            if(head == null) {
                head = new ListNode(sum);
                last = head;
            } else {
                last.next = new ListNode(sum);
                last = last.next;
            }
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }
        return head;
    }
}