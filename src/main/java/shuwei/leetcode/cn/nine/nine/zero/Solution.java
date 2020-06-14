package shuwei.leetcode.cn.nine.nine.zero;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  // 把应该相等的放在同一个Map中，不相等放另一个map
  public boolean equationsPossible(String[] equations) {
    Map<Character, Character> equals = new HashMap<>();
    Set<String> notEq = new HashSet<>();
    Map<Character, Character> notEquals = new HashMap<>();
    for (String str : equations) {
      char a = str.charAt(0);
      char o = str.charAt(1);
      char b = str.charAt(3);
      if (o == '=') {
        addEqual(equals, a, b);
      } else {
        if (a == b) {
          return false;
        }
        notEq.add(str);
      }
    }
    for(String str : notEq) {
      if (equalsAB(equals, str.charAt(0), str.charAt(3))) {
        return false;
      }
    }
    return true;
  }
  private boolean equalsAB(Map<Character, Character> equals, char a, char b) {
    Character tmp = equals.get(a);
    if (tmp == null) {
      return false;
    }
    while (equals.get(tmp) != null && tmp != equals.get(tmp)) {
      tmp = equals.get(tmp);
    }
    Character tmpB = equals.get(b);
    if (tmpB == null) {
      return false;
    }
    while (equals.get(tmpB) != null && tmpB != equals.get(tmpB)) {
      tmpB = equals.get(tmpB);
    }
    return tmp == tmpB;
  }

  private void addEqual(Map<Character, Character> map, char a, char b) {
    Character vA = map.get(a);
    Character vB = map.get(b);
    if (vA == null && vB == null) {
      map.put(a, b);
      map.put(b, b);
    } else if (vA == null) {
      map.put(a, vB);
    } else if (vB == null) {
      map.put(b, vA);
    } else {
      if (vA != vB) {
        map.put(vA, vB);
      }
    }
  }
}
