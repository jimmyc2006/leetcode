package shuwei.leetcode.cn.three.nine.nine;

import java.util.*;

public class Solution {
  /**
   * 需要记录有关系的变量的集合，然后这些关系对应的一个数值体系
   * 例如a/b=2,设置b=1,a=2；如果再出现a/c=3,说明c=2/3
   * 如果再出现d/e=2,那么e=1,d=2,但是d和b并没有关系,此时会出现2组数值体系，即(d,e)(a,b,c)
   * 如果此时再出现一个b/d=1,那么就需要合并这两个数值体系
   * 如果基于(a,b,c)合并，那么d的值就会变成1,那么e将变为0.5
   *
   * 如果基于之前已经出现的变量来归类的话，似乎就不会出现合并的情况
   *
   * Map的key使用Set的时候，Set的HashCode会跟着成员的变化的变化而变化
   * @param equations
   * @param values
   * @param queries
   * @return
   */
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    keyGroupList = new ArrayList<>();
    this.equations = equations;
    this.values = values;
    Map<Integer, Map<String, Double>> data = new HashMap<>();
    // 记录字符串都在哪些组出现过
    Map<String, Set<Integer>> indexs = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      List<String> pair = equations.get(i);
      indexs.computeIfAbsent(pair.get(0), k -> new HashSet()).add(i);
      indexs.computeIfAbsent(pair.get(1), k -> new HashSet<>()).add(i);
    }
    // 所有已经处理过的key
    Set<String> allUsed = new HashSet<>();
    for(Map.Entry<String, Set<Integer>> entry : indexs.entrySet()) {
      String key = entry.getKey();
      if (allUsed.add(key)) {
        Set<String> group = new HashSet<>();
        keyGroupList.add(group);
        group.add(key);
        Map<String, Double> vMap = new HashMap<>();
        data.put(keyGroupList.size() - 1, vMap);
        allUsed.addAll(dealGroup(key, indexs, group, vMap));
      }
    }
    double[] ans = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      String beichushu = queries.get(i).get(0);
      String chushu = queries.get(i).get(1);
      boolean ok = false;
      for (int j = 0; j < keyGroupList.size(); j++) {
        Set<String> groupKeys = keyGroupList.get(j);
        if (groupKeys.contains(beichushu) && groupKeys.contains(chushu)) {
          Map<String, Double> vMap = data.get(j);
          ans[i] = vMap.get(beichushu) / vMap.get(chushu);
          ok = true;
          break;
        }
      }
      if (!ok) {
        ans[i] = -1.0;
      }
    }
    return ans;
  }

  private List<List<String>> equations;
  private double[] values;
  private List<Set<String>> keyGroupList;

  // 处理某一组, 返回本次处理的所有key
  private Set<String> dealGroup(String key, Map<String, Set<Integer>> indexs,
                    Set<String> keyGroup, Map<String, Double> vMap) {
    // 初始化值为2
    vMap.put(key, 2.0);
    Set<String> used = new HashSet<>();
    Set<String> need2Deal = new HashSet<>();
    need2Deal.add(key);
    while(need2Deal.size() > 0) {
      Set<String> nextDeals = new HashSet<>();
      for (String k : need2Deal) {
        if(used.add(k)) {
          nextDeals.addAll(dealOne(k, indexs, keyGroup, vMap));
        }
      }
      need2Deal = nextDeals;
    }
    return used;
  }

  // 处理一个key，并返回所有跟它有关系的key的集合
  private Set<String> dealOne(String key, Map<String, Set<Integer>> indexs,
                              Set<String> keyGroup, Map<String, Double> valueMap) {
    Set<String> relationKeySet = new HashSet<>();
    double value = valueMap.get(key);
    for (int index :indexs.get(key)) {
      List<String> strings = this.equations.get(index);
      String beichushu = strings.get(0);
      String chushu = strings.get(1);
      if (key.equals(beichushu)) {
        valueMap.put(chushu, value / values[index]);
        relationKeySet.add(chushu);
      } else {
        valueMap.put(beichushu, value * values[index]);
        relationKeySet.add(beichushu);
      }
    }
    keyGroup.add(key);
    return relationKeySet;
  }
}
