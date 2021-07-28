package shuwei.leetcode.cn.eight.six.three;

import shuwei.leetcode.cn.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeNode.gen("3,5,1,6,2,0,8,null,null,7,4");
        TreeNode byValue = root.findByValue(5);
        Solution solution = new Solution();
        System.out.println(solution.distanceK(root, byValue, 2));
    }

    /**
     * 遍历一遍，找到目标节点，并且保存每个节点的parent，然后在找距离
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parentMap = new HashMap<>();
        findParent(root, target);
        return findUseDistince(target, k);
    }

    private Map<Integer, TreeNode> parentMap;

    private void findParent(TreeNode root, TreeNode target) {
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            if (root.left == target) {
                return;
            }
            findParent(root.left, target);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            if (root.right != target) {
                findParent(root.right, target);
            }
        }
    }
    private List<Integer> findUseDistince(TreeNode target, int distince) {
        Set<TreeNode> distanceNodes = new HashSet<>();
        distanceNodes.add(target);
        Set<TreeNode> useds = new HashSet<>();
        while (distince > 0 && distanceNodes.size() > 0) {
            Set<TreeNode> nextLevel = new HashSet<>();
            for (TreeNode eleNode : distanceNodes) {
                if (useds.add(eleNode)) {
                    TreeNode parent = parentMap.get(eleNode.val);
                    if (parent != null && !useds.contains(parent)) {
                        nextLevel.add(parent);
                    }
                    if (eleNode.left != null && !useds.contains(eleNode.left)) {
                        nextLevel.add(eleNode.left);
                    }
                    if (eleNode.right != null && !useds.contains(eleNode.right)) {
                        nextLevel.add(eleNode.right);
                    }
                }
            }
            distince--;
            distanceNodes = nextLevel;
        }
        return distanceNodes.stream().map(tn -> tn.val).collect(Collectors.toList());
    }
}
