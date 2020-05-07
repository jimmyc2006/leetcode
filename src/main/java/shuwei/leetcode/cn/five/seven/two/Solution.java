package shuwei.leetcode.cn.five.seven.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {

  // 第二次6ms，打败95%
  public boolean isSubtree(TreeNode s, TreeNode t) {
    Integer[] content = dfs(s);
    Integer[] pattern = dfs(t);
    return kmp(content, pattern);
  }
  
  public Integer[] dfs(TreeNode tn) {
    ArrayList<Integer> arrList = new ArrayList<>();
    // 深度优先搜索
    Stack<TreeNode> stack = new Stack<>();
    dealNode(tn, arrList);
    stack.add(tn);
    while (!stack.isEmpty()) {
      if (tn == null) {
        tn = stack.pop().right;
      } else {
        tn = tn.left;
      }
      dealNode(tn, arrList);
      if (tn != null) {
        stack.add(tn);
      }
    }
    return arrList.toArray(new Integer[arrList.size()]);
  }
  
  private boolean kmp(Integer[] content, Integer[] pattern) {
    int[] kmpIndex = kmpIndex(pattern);
    for (int i = 0, j = 0; i < content.length; ) {
      if (isEqual(content[i], pattern[j])) {
        i++;
        j++;
        if (j == pattern.length) {
           return true;
        }
      } else {
        if (j > 0) {
          j = kmpIndex[j - 1];
        } else {
          i++;
        }
      }
    }
    return false;
  }
  
  private int[] kmpIndex(Integer[] pattern) {
    int[] index = new int[pattern.length];
    int j = 0, i = 1;
    while (i < index.length) {
      if (isEqual(pattern[i], pattern[j])) {
        index[i] = j + 1;
        i++;
        j++;
      } else {
        if (j - 1 >= 0) {
          j = index[ j - 1];
        } else if (j > 0){
          j = 0;
        } else {
          i++;
        }
      }
    }
    return index;
  }
  
  private void dealNode(TreeNode tn, List<Integer> list) {
    if (tn != null) {
      list.add(tn.val);
    } else {
      list.add(null);
    }
  }
  
  private boolean isEqual(Integer i1, Integer i2) {
    if (i1 == null && i2 == null) {
      return true;
    } else if (i1 == null) {
      return false;
    } else if (i2 == null) {
      return false;
    } else {
      return i1.intValue() == i2.intValue();
    }
  }
  
  // 实现的求kmp的index数组的算法的备份
  public int[] kmpIndexB (String str) {
    char[] arr = str.toCharArray();
    int[] index = new int[arr.length];
    int j = 0, i = 1;
    while (i < index.length) {
      if (arr[i] == arr[j]) {
        index[i] = j + 1;
        i++;
        j++;
      } else {
        if (j - 1 >= 0) {
          j = index[ j - 1];
        } else if (j > 0){
          j = 0;
        } else {
          i++;
        }
      }
    }
    return index;
  }

  // 第一个版本，能通过，但是24ms，只打败5%
  public boolean isSubtree2(TreeNode s, TreeNode t) {
    // 对s进行bfs
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(s);
    while (!queue.isEmpty()) {
      TreeNode tn = queue.poll();
      if (tn.val == t.val && isSameTree(tn, t)) {
        return true;
      } else {
        if (tn.left != null) {
          queue.add(tn.left);
        }
        if (tn.right != null) {
          queue.add(tn.right);
        }
      }
    }
    return false;
  }

  private boolean isSameTree(TreeNode t1, TreeNode t2) {
    // 广度优先判断两个树是否相同
    Queue<TreeNode> queue1 = new LinkedList<>();
    queue1.add(t1);
    Queue<TreeNode> queue2 = new LinkedList<>();
    queue2.add(t2);
    while (true) {
      if (queue1.isEmpty() && queue2.isEmpty()) {
        return true;
      } else if (queue1.isEmpty()) {
        return false;
      } else if (queue2.isEmpty()) {
        return false;
      }
      TreeNode tmp1 = queue1.poll();
      TreeNode tmp2 = queue2.poll();
      if (tmp1.val != tmp2.val) {
        return false;
      }
      if (tmp1.left != null && tmp2.left != null) {
        queue1.add(tmp1.left);
        queue2.add(tmp2.left);
      } else if (tmp1.left != null) {
        return false;
      } else if (tmp2.left != null) {
        return false;
      }
      if (tmp1.right != null && tmp2.right != null) {
        queue1.add(tmp1.right);
        queue2.add(tmp2.right);
      } else if (tmp1.right != null) {
        return false;
      } else if (tmp2.right != null) {
        return false;
      }
    }
  }
}
