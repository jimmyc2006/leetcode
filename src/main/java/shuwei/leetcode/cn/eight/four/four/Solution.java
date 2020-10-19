package shuwei.leetcode.cn.eight.four.four;

public class Solution {
  public boolean backspaceCompare(String S, String T) {
    String strS = this.deal(S);
    String strT = this.deal(T);
    return strS.equals(strT);
  }

  private String deal(String s) {
    StringBuilder sb = new StringBuilder();
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '#') {
        if(sb.length() > 0 ) {
          sb.deleteCharAt(sb.length() - 1);
        }
      } else {
        sb.append(chars[i]);
      }
    }
    return sb.toString();
  }
}
