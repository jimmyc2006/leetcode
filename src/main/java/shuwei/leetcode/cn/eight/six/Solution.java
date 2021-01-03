package shuwei.leetcode.cn.eight.six;

import shuwei.leetcode.cn.ListNode;

public class Solution {

    /**
     * 定义新的list，遍历原来的listNode，把小于的放在一个list中，把其他的放在另一个list中，返回结果前把他们拼接在一起
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode low = null;
        ListNode lowHead = null;
        ListNode high = null;
        ListNode highHead = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x){
                if (low == null) {
                    low = cur;
                    lowHead = cur;
                } else {
                    low.next = cur;
                    low = low.next;
                }
            } else {
                if (high == null) {
                    high = cur;
                    highHead = cur;
                } else {
                    high.next = cur;
                    high = high.next;
                }
            }
            cur = cur.next;
        }
        if (high != null) {
            high.next = null;
        }
        if (low != null) {
            low.next = highHead;
            return lowHead;
        } else {
            return highHead;
        }
    }
}
