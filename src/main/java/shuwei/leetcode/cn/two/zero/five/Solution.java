package shuwei.leetcode.cn.two.zero.five;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  /**
   * 需要注意两个不同的字符映射到同一个字符的情况
   */
  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> map = new HashMap<>();
    Set<Character> maped = new HashSet();
    char[] chars = s.toCharArray();
    char[] chars1 = t.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      Character target = map.get(chars[i]);
      if (target != null) {
        if (target != chars1[i]) {
          return false;
        }
      } else {
        if (maped.contains(chars1[i])) {
          return false;
        }
        map.put(chars[i], chars1[i]);
        maped.add(chars1[i]);
      }
    }
    return true;
  }
}
