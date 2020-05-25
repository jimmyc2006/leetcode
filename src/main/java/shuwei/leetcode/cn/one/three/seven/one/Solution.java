package shuwei.leetcode.cn.one.three.seven.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int findTheLongestSubstring(String s) {
    char[] chars = s.toCharArray();
    int max = 0;
    int curr = 0;
    // 第一位表示a，第二位表示e，依此类推..
    int odds = 0;
    Map<Integer, Integer> oddTPos = new HashMap<>();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == 'a') {
        odds = odds ^ 1;
      } else if (chars[i] == 'e') {
        odds = odds ^ 2;
      } else if (chars[i] == 'i') {
        odds = odds ^ 4;
      } else if (chars[i] == 'o') {
        odds = odds ^ 8;
      } else if (chars[i] == 'u') {
        odds = odds ^ 16;
      } else {
        curr++;
        continue;
      }
      max = Math.max(max, curr);
      Integer pos = oddTPos.get(odds);
      if (pos == null) {
        if (odds == 0) {
          curr = i + 1;
        } else {
          oddTPos.put(odds, i);
          curr = 0;
        }
      } else {
        curr = i - pos;
      }
    }
    return Math.max(max, curr);
  }
}
