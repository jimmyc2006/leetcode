package shuwei.leetcode.cn.three.three.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  public List<String> findItinerary(List<List<String>> tickets) {
    total = tickets.size() + 1;
    ans = new ArrayList<>(total);
    Map<String, Queue<String>> map = new HashMap<>();
    for (List<String> ele : tickets) {
      Queue<String> targets = map.get(ele.get(0));
      if (targets == null) {
        targets = new PriorityQueue<>();
        map.put(ele.get(0), targets);
      }
      targets.add(ele.get(1));
    }
    Map<String, String[]> sMap = new HashMap<>();
    for (Map.Entry<String, Queue<String>> entry : map.entrySet()) {
      Queue<String> targets = entry.getValue();
      String[] tarStrs = new String[targets.size()];
      for (int i = 0; i < tarStrs.length; i++) {
        tarStrs[i] = targets.poll();
      }
      sMap.put(entry.getKey(), tarStrs);
    }
    ans.add("JFK");
    next(sMap, "JFK", 1);
    return ans;
  }

  private List<String> ans;
  private int total;

  private boolean next(Map<String, String[]> sMap, String key, int index) {
    if (index == total) {
      return true;
    }
    String[] queue = sMap.get(key);
    if (queue == null || queue.length < 1) {
      return false;
    } else {
      for (int i = 0 ; i < queue.length; i++) {
        if (queue[i] != null) {
          String next = queue[i];
          ans.add(next);
          queue[i] = null;
          if (next(sMap, next, index + 1)) {
            return true;
          }
          queue[i] = ans.remove(index);
        }
      }
      return false;
    }
  }
}
