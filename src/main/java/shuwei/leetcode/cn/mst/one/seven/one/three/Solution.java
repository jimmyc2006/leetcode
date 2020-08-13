package shuwei.leetcode.cn.mst.one.seven.one.three;

public class Solution {
  public int respace(String[] dictionary, String sentence) {
    Node root = new Node();
    for (String str : dictionary) {
      index(str, root);
    }
    int[] dp = new int[sentence.length() + 1];
    for (int i = 0; i < sentence.length(); i++) {
      dp[i + 1] = dp[i] + 1;
      Node curr = root;
      for (int j = i; j >= 0; j--) {
        int index = sentence.charAt(j) - 'a';
        if (curr.next[index] != null) {
          curr = curr.next[index];
          if (curr.isEnd) {
            dp[i + 1] = Math.min(dp[i + 1], dp[j]);
          }
        } else {
          break;
        }
      }
    }
    return dp[sentence.length()];
  }

  private void index(String str, Node root) {
    Node tmp = root;
    for (int i = str.length() - 1; i >= 0; i--) {
      char c = str.charAt(i);
      if (tmp.next[c - 'a'] == null) {
        tmp.next[c - 'a'] = new Node();
      }
      tmp = tmp.next[c - 'a'];
    }
    tmp.isEnd = true;
  }


  class Node {
    boolean isEnd = false;
    Node[] next = new Node[26];
  }
}
