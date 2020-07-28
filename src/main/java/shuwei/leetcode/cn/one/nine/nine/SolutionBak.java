package shuwei.leetcode.cn.one.nine.nine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuwei
 * @version 创建时间：2020年4月22日 上午8:53:13 类说明
 */
public class SolutionBak {

  //执行用时 :1 ms, 在所有 Java 提交中击败了97.36%的用户
  // 这个算法其实是一个bfs算法
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    TreeNode[] next = new TreeNode[] {root};
    result.add(root.val);
    while (next[0] != null) {
      TreeNode[] next2 = new TreeNode[next.length * 2];
      levelDown(next, next2, result);
      next = next2;
    }
    return result;
  }
  
  // 将下一层的最右边的点增加入结果集
  private void levelDown(TreeNode[] left2right, TreeNode[] nextTreeNodes, List<Integer> result) {
    int index = 0;
    for (int i = 0; i < left2right.length; i++) {
      TreeNode tmp = left2right[i];
      if (tmp == null) {
        break;
      }
      if (tmp.left != null) {
        nextTreeNodes[index++] = tmp.left;
      }
      if (tmp.right != null) {
        nextTreeNodes[index++] = tmp.right;
      }
    }
    if (index > 0) {
      result.add(nextTreeNodes[index - 1].val);
    }
  }

  // 2 ms
  // , 在所有 Java 提交中击败了
  // 31.17%
  // 的用户
  private List<TreeNode> levelDown(List<TreeNode> left2right) {
    List<TreeNode> result = new ArrayList<>(left2right.size());
    for (int i = 0; i < left2right.size(); i++) {
      TreeNode tmp = left2right.get(i);
      if (tmp.left != null) {
        result.add(tmp.left);
      }
      if (tmp.right != null) {
        result.add(tmp.right);
      }
    }
    return result;
  }
}
