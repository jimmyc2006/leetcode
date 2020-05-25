package shuwei.leetcode.cn.six.eight.zero;

public class Solution {
  // 7ms 97%
  public boolean validPalindrome(String s) {
    char[] content = s.toCharArray();
    return isValidPalindrome(content, 0, content.length - 1, false);
  }

  private boolean isValidPalindrome(char[] content, int start, int end, boolean isDeleted) {
    while (start < end) {
      if (content[start] == content[end]) {
        start++;
        end--;
      } else {
        if (isDeleted) {
          return false;
        } else {
          return isValidPalindrome(content, start, end - 1, true) ||
                  isValidPalindrome(content, start + 1, end, true);
        }
      }
    }
    return true;
  }
}
