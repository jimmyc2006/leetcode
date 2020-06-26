package shuwei.leetcode.cn.addTwoNumber2;

import java.util.HashMap;
import java.util.Map;

import shuwei.leetcode.cn.ListNode;

/**
 * @version 创建时间：2020年4月14日 下午2:53:49
 * 类说明
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = generate(3, 7);
        ListNode l2 = generate(9, 2);
        Solution s = new Solution();
        System.out.println(traversal(l1));
        System.out.println(traversal(l2));
        System.out.println(traversal(s.addTwoNumbers(l1, l2)));
    }

    public static String traversal(ListNode ln) {
        StringBuilder sb = new StringBuilder();
        sb.append(ln.val);
        while (ln.next != null) {
            ln = ln.next;
            sb.append("->" + ln.val);
        }
        return sb.toString();
    }

    public static ListNode generate(int start, int... vals) {
        ListNode root = new ListNode(start);
        ListNode curr = root;
        for (int i : vals) {
            ListNode next = new ListNode(i);
            curr.next = next;
            curr = next;

        }
        return root;
    }

    int remain = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        remain = 0;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int len1 = length(l1);
        int len2 = length(l2);
        ListNode ans;
        if (len1 > len2) {
            ans = this.add(l1, l2, len1, len2);
        } else {
            ans = this.add(l2, l1, len2, len1);
        }
        if (remain > 0) {
            ListNode a = new ListNode(remain);
            a.next = ans;
            ans = a;
        }
        return ans;
    }

    private int length(ListNode ln) {
        int length = 0;
        while (ln != null) {
            ln = ln.next;
            length++;
        }
        return length;
    }

    public ListNode add(ListNode l1, ListNode l2, int len1, int len2) {
        ListNode res = null;
        res = l1;
        if (len1 > len2) {
            res.next = add(l1.next, l2, len1 - 1, len2);
        } else if (len1 > 0) {
            res.val = res.val + l2.val;
            res.next = add(l1.next, l2.next, len1 - 1, len2 - 1);
        } else {
            return null;
        }
        int val = res.val + remain;
        res.val = val % 10;
        remain = val / 10;
        return res;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        String s1 = List2String(l1);
        String s2 = List2String(l2);
        int i = s1.length() - 1, j = s2.length() - 1;
        ListNode curNode = new ListNode(0);
        int cur = 0;
        ListNode next = null;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                cur = Integer.parseInt(String.valueOf(s1.charAt(i))) + Integer.parseInt(String.valueOf(s2.charAt(j))) + curNode.val;
                i--;
                j--;
            } else if (i >= 0) {
                cur = Integer.parseInt(String.valueOf(s1.charAt(i))) + curNode.val;
                i--;
            } else if (j >= 0) {
                cur = Integer.parseInt(String.valueOf(s2.charAt(j))) + curNode.val;
                j--;
            }
            next = curNode;
            if (cur >= 10) {
                curNode = new ListNode(1);
                cur = cur - 10;
            } else {
                curNode = new ListNode(0);
            }
            next.val = cur;
            curNode.next = next;
        }
        if (curNode.val > 0) {
            return curNode;
        } else {
            return next;
        }
    }

    public String List2String(ListNode ln) {
        StringBuilder sb = new StringBuilder();
        while (ln != null) {
            sb.append(ln.val);
            ln = ln.next;
        }
        return sb.toString();
    }
}
