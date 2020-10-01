package shuwei.leetcode.cn.one.seven;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  private char[][] letterIndex = new char[][]{
          new char[]{'a', 'b', 'c'},
          new char[]{'d', 'e', 'f'},
          new char[]{'g', 'h', 'i'},
          new char[]{'j', 'k', 'l'},
          new char[]{'m', 'n', 'o'},
          new char[]{'p', 'q', 'r', 's'},
          new char[]{'t', 'u', 'v'},
          new char[]{'w','x', 'y', 'z'}
  };
  /**
   * 标准的排列组合问题
   *
   */
  public List<String> letterCombinations(String digits) {
    ans = new ArrayList<>();
    if (digits.length() < 1) {
      return ans;
    }
    char[] content = digits.toCharArray();
    all(content, 0, new StringBuilder());
    return ans;
  }

  private List<String> ans;

  private void all(char[] content, int index, StringBuilder sb) {
    char[] letters = letterIndex[content[index] - '2'];
    for (int i = 0; i < letters.length; i++) {
      sb.append(letters[i]);
      if (index == content.length - 1) {
        ans.add(sb.toString());
      } else {
        all(content, index + 1, sb);
      }
      sb.deleteCharAt(index);
    }
  }
}
