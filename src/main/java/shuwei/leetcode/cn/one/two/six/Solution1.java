package shuwei.leetcode.cn.one.two.six;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution1 {

  // 第一步归类：分别放入hashMap中
  // BFS搜索 85ms
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> ans = new ArrayList<>();
    if (!wordList.contains(endWord)) {
      return ans;
    }
    Map<String, Set<String>> map = new HashMap<>();
    Map<String, List<Set<String>>> relations = new HashMap<>();
    relations.put(beginWord, this.put2Map(beginWord, map));
    for (String s : wordList) {
      relations.put(s, this.put2Map(s, map));
    }
    Map<String, Set<String>> finalRelations = new HashMap<>();
    for (Map.Entry<String, List<Set<String>>> entry : relations.entrySet()) {
      Set<String> rel = new HashSet<>();
      for (Set<String> s : entry.getValue()) {
        rel.addAll(s);
      }
      rel.remove(entry.getKey());
      finalRelations.put(entry.getKey(), rel);
    }
    return bfs(finalRelations, beginWord, endWord);
  }

  private List<List<String>> bfs(Map<String, Set<String>> map, String beginWord, String endWord) {
    List<List<String>> ans = new ArrayList<>();
    // 构建BFS的路径
    List<List<String>> left = new ArrayList<>();
    List<String> l = new ArrayList<>();
    l.add(beginWord);
    left.add(l);
    // 记录元素最早到达的步骤
    Map<String, Integer> leftSteps = new HashMap<>();
    leftSteps.put(beginWord, 0);
    List<List<String>> right = new ArrayList<>();
    List<String> r = new ArrayList<>();
    r.add(endWord);
    right.add(r);

    Map<String, Integer> rightSteps = new HashMap<>();
    rightSteps.put(endWord, 0);
    bfs(left, 1, right, 1, map, ans, leftSteps, rightSteps);
    return ans;
  }

  // 改为双向搜索
  private void bfs(List<List<String>> left, int leftStep, List<List<String>> right, int rightStep,
                   Map<String, Set<String>> map, List<List<String>> ans,
                   Map<String, Integer> leftSteps, Map<String, Integer> rightSteps) {
    // 是否出现过答案
    boolean hasResult = false;
    // left
    if (leftStep >= 0 && leftStep <= rightStep) {
      List<List<String>> nextLeftLevel = new ArrayList<>();
      for (List<String> ll : left) {
        String s = ll.get(ll.size() - 1);
        Set<String> nextLevs = map.get(s);
        for (String tmp : nextLevs) {
          Integer beforeStep = leftSteps.get(tmp);
          Integer rStep = rightSteps.get(tmp);
          if (rStep != null) {
            hasResult = true;
            for (List<String> eRig : right) {
              int last = rStep;
              if (eRig.get(last).equals(tmp)) {
                List<String> result = new ArrayList<>(ll);
                while (last >= 0) {
                  result.add(eRig.get(last));
                  last--;
                }
                ans.add(result);
              }
            }
          } else if (beforeStep != null && beforeStep < leftStep) {
            continue;
          } else {
            List<String> n = new ArrayList<>(ll);
            n.add(tmp);
            nextLeftLevel.add(n);
            leftSteps.put(tmp, leftStep);
          }
        }
      }
      if (!hasResult) {
        if (!nextLeftLevel.isEmpty()) {
          leftStep++;
        } else {
          leftStep = -1;
        }
        bfs(nextLeftLevel, leftStep, right, rightStep, map, ans, leftSteps, rightSteps);
      }
    } else if (rightStep >= 0) {
      List<List<String>> nextRightLevel = new ArrayList<>();
      for (List<String> rr : right) {
        String lastR = rr.get(rr.size() - 1);
        Set<String> nextRightLev = map.get(lastR);
        for (String r : nextRightLev) {
          Integer rStep = rightSteps.get(r);
          Integer lStep = leftSteps.get(r);
          if (lStep != null) {
            hasResult = true;
            for (List<String> ele : left) {
              if (ele.get(lStep).equals(r)) {
                List<String> result = new ArrayList<>(ele.subList(0, lStep + 1));
                int ind = rr.size() - 1;
                while (ind >= 0) {
                  result.add(rr.get(ind));
                  ind--;
                }
                ans.add(result);
              }
            }
          } else if (rStep != null && rStep < rightStep) {
            continue;
          } else {
            List<String> n = new ArrayList<>(rr);
            n.add(r);
            nextRightLevel.add(n);
            rightSteps.put(r, rightStep);
          }
        }
      }
      if (!hasResult) {
        if (!nextRightLevel.isEmpty()) {
          rightStep++;
        } else {
          rightStep = -1;
        }
        bfs(left, leftStep, nextRightLevel, rightStep, map, ans, leftSteps, rightSteps);
      }
    }
  }

  private List<Set<String>> put2Map(String str, Map<String, Set<String>> map) {
    List<Set<String>> allRelation = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      String category = getCategory(str, i);
      Set<String> trans = map.get(category);
      if (trans == null) {
        trans = new HashSet<>();
        map.put(category, trans);
      }
      trans.add(str);
      allRelation.add(trans);
    }
    return allRelation;
  }

  private String getCategory(String src, int index) {
    return src.substring(0, index) + "*" + src.substring(index + 1, src.length());
  }
}
