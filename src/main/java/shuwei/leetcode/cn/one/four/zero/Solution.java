package shuwei.leetcode.cn.one.four.zero;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

  /**
   * 先构建单词树，然后dfs
   */
  public List<String> wordBreak(String s, List<String> wordDict) {
    if (s == null || wordDict.size() < 1) {
      return new ArrayList<>();
    }
    DictTree dictTree = genDictTree(wordDict);
    // 表示从哪能到达该索引
    List<Integer>[] fromIndexs = new ArrayList[s.length() + 1];
    // 从前往后找
    char[] srcs = s.toCharArray();
    for (int i = 0 ; i < srcs.length; i++) {
      if (i == 0 || fromIndexs[i] != null) {
        List<Integer> toTargets = target(srcs, i, dictTree);
        for (Integer ele : toTargets) {
          if (fromIndexs[ele] == null) {
            fromIndexs[ele] = new ArrayList<>();
          }
          fromIndexs[ele].add(i);
        }
      }
    }
    // 从后往前遍历，获取最终结果
    List<String> ans = new ArrayList<>();
    addResult(srcs, fromIndexs, ans, srcs.length, new LinkedList<>());
    return ans;
  }

  private void addResult (char[] srcs, List<Integer>[] fromIndexs, List<String> ans, int index, LinkedList<String> tmpResult) {
    List<Integer> fromIndex = fromIndexs[index];
    if (fromIndex == null) {
      return;
    }
    for (Integer from : fromIndex) {
      if (from == 0) {
        tmpResult.addFirst(new String(srcs, 0, index));
        ans.add(String.join(" ", tmpResult));
        tmpResult.removeFirst();
      } else {
        tmpResult.addFirst(new String(srcs, from, index - from));
        addResult(srcs, fromIndexs, ans, from, tmpResult);
        tmpResult.removeFirst();
      }
    }
  }

  private List<Integer> target(char[] chars, int index, DictTree root) {
    List<Integer> targets = new ArrayList<>();
    while (index < chars.length) {
      if (root.nexts[chars[index] - 'a'] != null) {
        root = root.nexts[chars[index] - 'a'];
        index++;
        if (root.isEnd) {
          targets.add(index);
        }
      } else {
        break;
      }
    }
    return targets;
  }

  private DictTree genDictTree(List<String> wordDict) {
    DictTree result = new DictTree();
    for (String ele : wordDict) {
      add2Tree(ele.toCharArray(), 0, result);
    }
    return result;
  }

  private void add2Tree(char[] chars, int index, DictTree node) {
    if (index == chars.length) {
      node.isEnd = true;
    } else {
      if (node.nexts[chars[index] - 'a'] == null) {
        node.nexts[chars[index] - 'a'] = new DictTree();
      }
      add2Tree(chars, index + 1, node.nexts[chars[index] - 'a']);
    }
  }

  private class DictTree {
    DictTree[] nexts = new DictTree[26];
    boolean isEnd = false;
  }

}
