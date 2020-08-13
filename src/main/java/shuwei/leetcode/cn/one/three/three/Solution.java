package shuwei.leetcode.cn.one.three.three;

import shuwei.leetcode.cn.Node;

public class Solution {

    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        if (node.neighbors == null || node.neighbors.size() <1) {
            return new Node(node.val);
        }
        return b(node);
    }
    private Node[] nodes = new Node[101];

    private Node b(Node node) {
        int index = node.val;
        if (nodes[index] == null) {
            nodes[index] = new Node(node.val);
            if(node.neighbors != null) {
                for (Node ele : node.neighbors) {
                    nodes[index].neighbors.add(b(ele));
                }
            }
        }
        return nodes[index];
    }
}
