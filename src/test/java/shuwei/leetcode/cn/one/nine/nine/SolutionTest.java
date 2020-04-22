package shuwei.leetcode.cn.one.nine.nine;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author shuwei
 * @version 创建时间：2020年4月22日 下午1:46:19 类说明
 */
public class SolutionTest {
  @Test
  public void test1() {
    Solution s = new Solution();
    // System.out.println(s.rightSideView(root));
    TreeNode root = genTreeNode(new Integer[] {1, 2, 3, null, 5, null, 4});
    List<Integer> expectedRes = Arrays.asList(1, 3, 4);
    List<Integer> result = s.rightSideView(root);
    Assert.assertEquals(true, expectedRes.containsAll(result));
    Assert.assertEquals(true, expectedRes.size() == result.size());
  }

  @Test
  public void test2() {
    Solution s = new Solution();
    // System.out.println(s.rightSideView(root));
    TreeNode root = genTreeNode(new Integer[] {1, 2, 3, 4});
    List<Integer> result = s.rightSideView(root);
    List<Integer> expectedRes = Arrays.asList(1, 3, 4);
    Assert.assertEquals(true, expectedRes.containsAll(result));
    Assert.assertEquals(true, expectedRes.size() == result.size());
  }

  @Test
  public void test3() {
    Solution s = new Solution();
    // System.out.println(s.rightSideView(root));
    TreeNode root = genTreeNode(new Integer[] {4, 3, 6, 1, null, 5, null, null, 2});
    List<Integer> result = s.rightSideView(root);
    System.out.println(result);
  }

  // 将数组类型的二叉树，转变为链表表示方式
  public TreeNode genTreeNode(Integer[] data) {
    TreeNode root = new TreeNode(data[0]);
    gen(data, 0, root);
    return root;
  }

  private void gen(Integer[] data, int index, TreeNode currTN) {
    if (2 * index + 1 < data.length && data[2 * index + 1] != null) {
      currTN.left = new TreeNode(data[2 * index + 1]);
      gen(data, 2 * index + 1, currTN.left);
    }
    if (2 * index + 2 < data.length && data[2 * index + 2] != null) {
      currTN.right = new TreeNode(data[2 * index + 2]);
      gen(data, 2 * index + 2, currTN.right);
    }
  }

}
