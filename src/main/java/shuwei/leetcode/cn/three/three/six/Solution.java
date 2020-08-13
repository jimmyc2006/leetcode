package shuwei.leetcode.cn.three.three.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public List<List<Integer>> palindromePairs(String[] words) {
    //构建trie
    TrieNode root = buildTire(words);
    List<List<Integer>> res = new ArrayList();
    //对于每个单词,在trie中搜索
    for (int i = 0; i < words.length; i++) {
      search(words[i], i, root, res);
    }
    return res;
  }

  private void search(String word, int i, TrieNode node, List<List<Integer>> res) {
    int k = word.length(), j = 0;
    for (; j < k; j++) {
      //循环中在trie中发现的单词是比当前word长度要短的
      char c = word.charAt(j);
      if (node.index != -1 && isPalidrome(word, j, k - 1)) {
        res.add(Arrays.asList(i, node.index));
      }
      //所有可能被排除，提前退出
      if (node.children[c - 'a'] == null) return;

      node = node.children[c - 'a'];
    }
    //长度等于当前搜索的word的单词
    if (node.index != -1 && node.index != i) {
      res.add(Arrays.asList(i, node.index));
    }
    //长度长于当前搜索的word的单词
    for (int rest : node.belowIsPali) {
      res.add(Arrays.asList(i, rest));
    }
  }

  private TrieNode buildTire(String[] words) {
    TrieNode root = new TrieNode();
    for (int i = 0; i < words.length; i++) {
      addWord(root, words[i], i);
    }
    return root;
  }

  private void addWord(TrieNode root, String word, int i) {
    for (int j = word.length() - 1; j >= 0; j--) {
      if (isPalidrome(word, 0, j)) {
        root.belowIsPali.add(i);
      }
      char c = word.charAt(j);
      if (root.children[c - 'a'] == null) {
        root.children[c - 'a'] = new TrieNode();
      }
      root = root.children[c - 'a'];
    }
    root.index = i;
  }

  private boolean isPalidrome(String word, int i, int j) {
    if (word.length() <= 1) {
      return true;
    }
    while (i < j) {
      if (word.charAt(i++) != word.charAt(j--)) return false;
    }
    return true;
  }

  class TrieNode {
    int index;
    List<Integer> belowIsPali;
    TrieNode[] children;

    public TrieNode() {
      index = -1;
      belowIsPali = new ArrayList<Integer>();
      children = new TrieNode[26];
    }
  }
//  // 自己写的只能5%
//  public List<List<Integer>> palindromePairs(String[] words) {
//    List<List<Integer>> ans = new ArrayList<>();
//    List<String>[] strIndex = new List[26];
//    Map<String, Integer> indexMap = new HashMap<>();
//    for (int i = 0; i < strIndex.length; i++) {
//      strIndex[i] = new ArrayList<>();
//    }
//    for(int i = 0; i < words.length; i++) {
//      if (words[i].length() < 1) {
//        continue;
//      }
//      strIndex[words[i].charAt(0) - 'a'].add(words[i]);
//      indexMap.put(words[i], i);
//    }
//    for (int i = 0 ; i < words.length; i++) {
//      String curr = words[i];
//      if (curr.length() < 1) {
//        for (int j = 0 ; j < words.length; j++) {
//          if (i != j && isBack(words[j])) {
//            ans.add(Arrays.asList(new Integer[]{j, i}));
//            ans.add(Arrays.asList(new Integer[]{i, j}));
//          }
//        }
//      } else {
//        for (String s : strIndex[curr.charAt(curr.length() - 1) - 'a']) {
//          int index = indexMap.get(s);
//          if (index != i) {
//            if (isBack(s + curr)) {
//              ans.add(Arrays.asList(new Integer[]{index, i}));
//            }
//          }
//        }
//      }
//    }
//    return ans;
//  }
//
//  private boolean isBack(String str) {
//    for (int i = 0, j = str.length() - 1; i < j; i++,j--) {
//      if (str.charAt(i) != str.charAt(j)) {
//        return false;
//      }
//    }
//    return true;
//  }

}
