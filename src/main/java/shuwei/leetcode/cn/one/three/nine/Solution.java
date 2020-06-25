package shuwei.leetcode.cn.one.three.nine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    Map<Character, Set<String>> endCharMap = new HashMap<>();
    for (String ele : wordDict) {
      char endChar = ele.charAt(ele.length() - 1);
      Set<String> words = endCharMap.computeIfAbsent(endChar, k -> new HashSet<>());
      words.add(ele);
    }
    boolean[] f = new boolean[s.length() + 1];
    f[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      char lastChar = s.charAt(i - 1);
      Set<String> words = endCharMap.get(lastChar);
      if (words == null || words.isEmpty()) {
        f[i] = false;
      } else {
        String tmp = s.substring(0, i);
        for (String ele : words) {
          if (tmp.endsWith(ele)) {
            f[i] = f[i - ele.length()];
            if (f[i]) {
              break;
            }
          }
        }
      }
    }
    return f[s.length()];
  }
}
