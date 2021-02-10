package shuwei.leetcode.cn.five.six.seven;

public class Solution {
  public boolean checkInclusion(String s1, String s2) {
    int[] remains = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      remains[s1.charAt(i) - 'a']++;
    }
    int left = -1, right = 0;
    while (right < s2.length()) {
      int index = s2.charAt(right) - 'a';
      if (remains[index] == 0) {
        while (left >= 0) {
          char reback = s2.charAt(left);
          left++;
          if (reback == s2.charAt(right)) {
            right++;
            break;
          }
          remains[reback - 'a']++;
          if (left == right) {
            left = -1;
          }
        }
        if (left == -1) {
          right++;
        }
      } else {
        if (left < 0) {
          left = right;
        }
        if (right - left == s1.length() - 1) {
          return true;
        }
        right++;
        remains[index]--;
      }
    }
    return false;
  }
}
