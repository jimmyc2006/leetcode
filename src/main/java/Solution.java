import java.util.*;

/**
 * @author shuwei
 * @version 创建时间：2017年9月15日 下午9:01:23 类说明
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,2,3,4]
        System.out.println(Arrays.toString(s.restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}})));
        // [-2,4,1,-3]
        System.out.println(Arrays.toString(s.restoreArray(new int[][]{{4, -2}, {1, 4}, {-3, 1}})));
        // 100000,-100000
        System.out.println(Arrays.toString(s.restoreArray(new int[][]{{100000, -100000}})));
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Integer[]> relations = new HashMap<>();
        for (int[] eleAdj : adjacentPairs) {
            put(relations, eleAdj[0], eleAdj[1]);
            put(relations, eleAdj[1], eleAdj[0]);
        }
        Map<Integer, Node> val2NodeMap = new HashMap<>();
        List<Node> nodes = new ArrayList<>();
        for (Map.Entry<Integer, Integer[]> entry : relations.entrySet()) {
            if (val2NodeMap.get(entry.getKey()) == null) {
                deal(relations, val2NodeMap, entry.getKey(), nodes);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (Node node : nodes) {
            appendNode2List(ans, findHead(node));
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private void appendNode2List(List<Integer> res, Node head) {
        while (head != null) {
            res.add(head.val);
            head = head.right;
        }
    }

    private Node findHead(Node node) {
        Node head = node;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

    private void deal(Map<Integer, Integer[]> relations, Map<Integer, Node> val2NodeMap, int currValue,
                      List<Node> resNodes) {
        if (val2NodeMap.get(currValue) == null) {
            Node node = new Node();
            node.val = currValue;
            val2NodeMap.put(currValue, node);
            resNodes.add(node);
        }
        Integer[] relationNode = relations.get(currValue);
        if (relationNode != null) {
            Node currNode = val2NodeMap.get(currValue);
            for (Integer integer : relationNode) {
                if (integer != null) {
                    if (val2NodeMap.get(integer) == null) {
                        Node rel = new Node();
                        rel.val = integer;
                        if (currNode.left == null) {
                            currNode.left = rel;
                            rel.right = currNode;
                        } else {
                            currNode.right = rel;
                            rel.left = currNode;
                        }
                        val2NodeMap.put(integer, rel);
                        deal(relations, val2NodeMap, integer, resNodes);
                    }
                }
            }
        }
    }

    private void put(Map<Integer, Integer[]> data, int from, int to) {
        if (data.get(from) == null) {
            data.put(from, new Integer[2]);
        }
        if (data.get(from)[0] == null) {
            data.get(from)[0] = to;
        } else {
            data.get(from)[1] = to;
        }
    }
}

class Node {
    int val;
    Node left;
    Node right;
}