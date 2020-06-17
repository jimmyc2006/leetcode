package shuwei.leetcode.cn.two.nine.seven;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LM {
    private static Map<Integer, TreeNode> MAP = new ConcurrentHashMap<>();
    private static AtomicInteger AI = new AtomicInteger();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return null;
        }
        int a = AI.incrementAndGet();
        MAP.put(a, root);
        return Integer.toString(a);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null){
            return null;
        }
        int a = Integer.parseInt(data);
        return MAP.get(a);
    }
}
