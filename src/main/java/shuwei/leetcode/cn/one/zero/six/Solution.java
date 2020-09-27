package shuwei.leetcode.cn.one.zero.six;

import java.util.HashMap;
import java.util.Map;

import shuwei.leetcode.cn.TreeNode;

public class Solution {

  private int[] inorder;
  private int[] postorder;
  private int index;
  private Map<Integer, Integer> value2Index;

  /**
   * 中序遍历 inorder = [9,3,15,20,7]
   * 后序遍历 postorder = [9,15,7,20,3]
   * 3是后续遍历最后一个元素，是根；
   * 而在中序遍历中：3的左边是9，是它的左子树；3的右边有3个数值，它们是3的右子树
   * 这样，我们就可以通过倒着遍历后续的结果，（后续原本是左->右->中，倒着就是中->右->左）就可以还原树
   * 但是必须要借助中序数组来控制数量
   * 需要体会这种还原问题，这个问题可以抽象到所有的根据一定条件的还原问题
   * @param inorder
   * @param postorder
   * @return
   */
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null) {
      return null;
    }
    this.inorder = inorder;
    this.postorder = postorder;
    index = postorder.length - 1;
    value2Index = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      value2Index.put(inorder[i], i);
    }
    TreeNode root = find(0, index);
    return root;
  }

  private TreeNode find(int startIndex, int endIndex) {
    if (startIndex > endIndex) {
      return null;
    }
    int lastValue = postorder[index--];
    int indexInInorder = value2Index.get(lastValue);
    TreeNode node = new TreeNode(lastValue);
    node.right = find(indexInInorder + 1, endIndex);
    node.left = find(startIndex, indexInInorder - 1);
    return node;
  }
}
