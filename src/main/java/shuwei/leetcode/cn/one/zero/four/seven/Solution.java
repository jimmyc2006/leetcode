package shuwei.leetcode.cn.one.zero.four.seven;

public class Solution {
  public String removeDuplicates(String S) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);
      if (sb.length() == 0)  {
        sb.append(ch);
      } else if (sb.charAt(sb.length() - 1) == ch) {
        sb.deleteCharAt(sb.length() - 1);
      } else {
        sb.append(ch);
      }
    }
    return sb.toString();
  }
}
