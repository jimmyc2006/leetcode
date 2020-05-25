package shuwei.leetcode.cn.five;

public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.longestPalindrome("babad"));
    System.out.println(s.longestPalindrome("bb"));
    System.out.println(s.longestPalindrome("dabad"));
  }

  // 暴力法，12ms beat 91%
  public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) {
      return "";
    }
    char[] chars = s.toCharArray();
    int max = 1;
    int maxStart = 0;
    int maxEnd = 1;
    for (int i = 0; i < chars.length; i++) {
      if (i - 1 >= 0 && chars[i - 1] == chars[i]) {
        int thisMax = maxLengthSame(chars, i - 2, i + 1) + 2;
        if (thisMax > max) {
          max = thisMax;
          maxStart = i - thisMax / 2;
          maxEnd = i + thisMax / 2;
        }
      }
      if (i - 1 >= 0 && i + 1 < chars.length && chars[i - 1] == chars[i + 1]) {
        int thisMax = maxLengthSame(chars, i - 2, i + 2) + 3;
        if (thisMax > max) {
          max = thisMax;
          maxStart = i - thisMax / 2;
          maxEnd = i + thisMax / 2 + 1;
        }
      }
    }
    return s.substring(maxStart, maxEnd);
  }

  private int maxLengthSame(char[] chars, int left, int right) {
    int max = 0;
    while (left >= 0 && right < chars.length) {
      if (chars[left] == chars[right]) {
        max += 2;
        left--;
        right++;
      } else {
        break;
      }
    }
    return max;
  }
}
