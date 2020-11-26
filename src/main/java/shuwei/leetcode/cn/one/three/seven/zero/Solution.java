package shuwei.leetcode.cn.one.three.seven.zero;

public class Solution {

  public String sortString(String s) {
    if (s.length() <= 1) {
      return s;
    }
    char[] chars = s.toCharArray();
    int[] counts = new int[26];
    for (char ele : chars) {
        counts[ele - 'a']++;
    }
    StringBuilder ans = new StringBuilder();
    while (ans.length() < chars.length) {
      for (int i = 0; i < 26; i++) {
        if(counts[i] > 0){
          counts[i]--;
          ans.append((char)(i + 'a'));
        }
      }
      if (ans.length() < chars.length) {
        for (int i = 25; i >= 0; i--) {
          if(counts[i] > 0) {
            counts[i]--;
            ans.append((char)(i + 'a'));
          }
        }
      }
    }
    return ans.toString();
  }

}
