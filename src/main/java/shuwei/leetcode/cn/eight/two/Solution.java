package shuwei.leetcode.cn.eight.two;

import shuwei.leetcode.cn.ListNode;

public class Solution {
    /**
     * root表示头部
     * pre表示重复的上一个节点
     * curr表示当前重复的节点
     * 1,2,3,3,4,4,5
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = null, pre = null, curr, next;
        boolean isRepeat = false;
        curr = head;
        while (curr != null) {
            next = curr.next;
            if (next != null) {
                if (next.val == curr.val) {
                    isRepeat = true;
                    curr.next = next.next;
                } else {
                    if (isRepeat) {
                        if (pre == null) {
                            curr = next;
                        } else {
                            pre.next = next;
                            curr = next;
                        }
                        isRepeat = false;
                    } else {
                        if (root == null) {
                            root = curr;
                        }
                        pre = curr;
                        curr = next;
                    }
                }
            } else {
                if (isRepeat) {
                    if (pre != null) {
                        pre.next = null;
                    }
                    return root;
                }
                if (root == null) {
                    return curr;
                }
                return root;
            }
        }
        return root;
    }
}
