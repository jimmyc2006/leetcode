package shuwei.leetcode.cn.two.four.two;

import java.util.Arrays;

public class Solution {

  public boolean isAnagram(String s, String t) {
    if (s == null) {
      return t == null;
    }
    if (t == null) {
      return s == null;
    }
    if (s.length() < 1) {
      return t.length() < 1;
    }
    if (t.length() < 1) {
      return s.length() < 1;
    }
    int[] s1 = charArray2int(s.toCharArray());
    int[] s2 = charArray2int(t.toCharArray());
    return Arrays.equals(s1, s2);
  }

  private int[] charArray2int(char[] chars) {
    int[] result = new int[26];
    for (char ele : chars) {
      result[ele - 'a']++;
    }
    return result;
  }

}
