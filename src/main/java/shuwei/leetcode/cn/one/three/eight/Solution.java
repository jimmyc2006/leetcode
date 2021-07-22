package shuwei.leetcode.cn.one.three.eight;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            Node copyNode = new Node(curr.val);
            map.put(curr, copyNode);
            curr = curr.next;
        }
        curr = head;
        while(curr != null) {
            Node copy = map.get(curr);
            Node next = curr.next;
            if (next != null) {
                copy.next = map.get(next);
            }
            Node random = curr.random;
            if (random != null) {
                copy.random = map.get(random);
            }
            curr = next;
        }
        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
