package shuwei.leetcode.cn.seven.six;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
  // 思路法，17ms，打败61%，明天学习下官方的方法
  public String minWindow(String s, String t) {
    char[] sChs = s.toCharArray();
    char[] tChas = t.toCharArray();
    Map<Character, Integer> tCount = new HashMap<>();
    Set<Character> tSet = new HashSet<>();
    for (int i = 0; i < tChas.length; i++) {
      tSet.add(tChas[i]);
      Integer count = tCount.get(tChas[i]);
      if (count == null) {
        tCount.put(tChas[i], 1);
      } else {
        tCount.put(tChas[i], count + 1);
      }
    }
    // 保存多余的匹配
    Map<Character, Integer> surplus = new HashMap<>();
    Queue<Integer> indexs = new LinkedList<>();
    int min = s.length();
    int minStart = -1;
    int minEnd = -1;
    for (int i = 0; i < sChs.length; i++) {
      if (tSet.contains(sChs[i])) {
        indexs.add(i);
        Integer c = tCount.get(sChs[i]);
        if (c == null) {
          Integer sur = surplus.get(sChs[i]);
          if (sur == null) {
            surplus.put(sChs[i], 1);
          } else {
            surplus.put(sChs[i], ++sur);
          }
        } else {
          if (--c == 0) {
            tCount.remove(sChs[i]);
            if (tCount.isEmpty()) {
              int theStart = indexs.peek();
              Integer sur = surplus.get(sChs[theStart]);
              while (sur != null && sur > 0) {
                surplus.put(sChs[theStart], --sur);
                indexs.poll();
                theStart = indexs.peek();
                sur = surplus.get(sChs[theStart]);
              }
              if (i - theStart < min) {
                min = i - theStart;
                minStart = theStart;
                minEnd = i + 1;
              }
              theStart = indexs.poll();
              tCount.put(sChs[theStart], 1);
            }
          } else {
            tCount.put(sChs[i], c);
          }
        }
      }
    }
    if (minStart != -1) {
      return s.substring(minStart, minEnd);
    } else {
      return "";
    }
  }
}
