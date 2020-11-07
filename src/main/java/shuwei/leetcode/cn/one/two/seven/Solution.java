package shuwei.leetcode.cn.one.two.seven;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

  /**
   * 广度优先搜索，先构建关系 然后求最短距离 如何构建关系？ 遍历所有字典，每个单词换一个字母，然后检查字段中是否有这个单词
   */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> dictSet = new HashSet<>(wordList);
    if (!dictSet.contains(endWord) || beginWord.equals(endWord)) {
      return 0;
    }
    dictSet.add(beginWord);
    Map<String, Set<String>> relations = this.targetStrings(dictSet);
    int ans = 1;
    // 两边向中间逼近
    Set<String> leftAll = new HashSet<>();
    leftAll.add(beginWord);
    Set<String> leftNext = new HashSet<>();
    leftNext.add(beginWord);

    Set<String> rightAll = new HashSet<>();
    rightAll.add(endWord);
    Set<String> rightNext = new HashSet<>();
    rightNext.add(endWord);
    while (leftNext.size() > 0 && rightNext.size() > 0) {
      leftNext = findNexts(leftNext, relations, leftAll);
      ans++;
      if (has(leftNext, rightNext)) {
        return ans;
      }
      rightNext = findNexts(rightNext, relations, rightAll);
      ans++;
      if (has(leftNext, rightNext)) {
        return ans;
      }
    }
    return 0;
  }

  private Set<String> findNexts(Set<String> currs, Map<String, Set<String>> relations, Set<String> all) {
    Set<String> result = new HashSet<>();
    for (String ele : currs) {
      result.addAll(relations.get(ele));
    }
    result.removeAll(all);
    all.addAll(result);
    return result;
  }

  private boolean has(Set<String> s1, Set<String> s2) {
    if (s1.size() < s2.size()) {
      for (String ele : s1) {
        if (s2.contains(ele)) {
          return true;
        }
      }
    } else {
      for (String ele : s2) {
        if (s1.contains(ele)) {
          return true;
        }
      }
    }
    return false;
  }

  private Map<String, Set<String>> targetStrings(Set<String> dictSet) {
    Map<String, Set<String>> strRelation = new HashMap<>();
    for (String ele : dictSet) {
      for (int i = 0; i < ele.length(); i++) {
        String star;
        if (i + 1 < ele.length()) {
          star = ele.substring(0, i) + "*" + ele.substring(i + 1);
        } else {
          star = ele.substring(0, i) + "*";
        }
        Set<String> has = strRelation.get(star);
        if (has == null) {
          has = new HashSet<>();
          strRelation.put(star, has);
        }
        has.add(ele);
      }
    }
    Map<String, Set<String>> relations = new HashMap<>();
    for (String ele : dictSet) {
      Set<String> res = relations.get(ele);
      if (res == null) {
        res = new HashSet<>();
        relations.put(ele, res);
      }
      for (int i = 0; i < ele.length(); i++) {
        String star;
        if (i + 1 < ele.length()) {
          star = ele.substring(0, i) + "*" + ele.substring(i + 1);
        } else {
          star = ele.substring(0, i) + "*";
        }
        res.addAll(strRelation.get(star));
      }
    }
    return relations;
  }

}
