package shuwei.leetcode.cn.one.one.seven.eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  /**
   * 根据题就思路二，领悟了某个字母可选可不选的时候，可以使用递归处理
   * 其实仔细想想这个有点类似背包问题
   * @param words
   * @param puzzles
   * @return
   */
  private Trie root;
  public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
    root = new Trie();
    // 构建字典树
    for (String word : words) {
      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      add(chars);
    }
    // 寻找答案
    List<Integer> ans = new ArrayList<>(puzzles.length);
    for (String puzzle : puzzles) {
      char[] chars = puzzle.toCharArray();
      first = chars[0];
      Arrays.sort(chars);
      find = chars;
      ans.add(find(0, root));
    }
    return ans;
  }

  private char[] find;
  private char first;
  private int find(int index, Trie node) {
    if (node == null) {
      return 0;
    }
    if (index == find.length) {
      return node.counts;
    }
    if (find[index] == first) {
      return find(index + 1, node.children[first - 'a']);
    } else {
      return find(index + 1, node) + find(index + 1, node.children[find[index] - 'a']);
    }
  }


  private void add (char[] chars) {
    Trie node = root;
    for (int i = 0; i < chars.length; i++) {
      if (i > 0 && chars[i] == chars[i - 1]) {
        continue;
      }
      int index = chars[i] - 'a';
      if (node.children[index] == null) {
        node.children[index] = new Trie();
      }
      node = node.children[index];
    }
    node.counts++;
  }

  class Trie {
    int counts = 0;
    private Trie[] children = new Trie[26];
  }
}

