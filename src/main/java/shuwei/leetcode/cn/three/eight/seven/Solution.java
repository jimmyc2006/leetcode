package shuwei.leetcode.cn.three.eight.seven;

public class Solution {

  public int firstUniqChar(String s) {
    if (s == null || s.length() < 1) {
      return -1;
    }
    char[] chars = s.toCharArray();
    int[] counts = new int[26];
    for (int i = chars.length - 1; i >= 0; i--) {
      counts[chars[i] - 'a']++;
    }
    for (int i = 0; i < chars.length; i++) {
      if (counts[chars[i] - 'a'] == 1) {
        return i;
      }
    }
    return -1;
  }
}
