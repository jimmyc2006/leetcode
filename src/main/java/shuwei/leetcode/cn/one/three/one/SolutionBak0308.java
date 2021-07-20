package shuwei.leetcode.cn.one.three.one;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolutionBak0308 {

  public List<List<String>> partition(String s) {
    this.s = s;
    ans = new ArrayList<>();
    length = s.length();
    isHuiwen = new Boolean[length][length];
    content = s.toCharArray();
    middleResult = new LinkedList();
    deal(0);
    return ans;
  }

  private void deal(int start) {
    if (start == length) {
      ans.add((List<String>) middleResult.clone());
    }
    for (int i = start; i < length; i++) {
      if (isHuiwen(start, i)) {
        middleResult.add(s.substring(start, i + 1));
        deal(i + 1);
        middleResult.removeLast();
      }
    }
  }

  private Boolean[][] isHuiwen;

  private boolean isHuiwen(int left, int right) {
    if (left >= right) {
      return true;
    }
    if (isHuiwen[left][right] != null) {
      return isHuiwen[left][right];
    }
    boolean res = (content[left] == content[right] && isHuiwen(left + 1, right - 1));
    isHuiwen[left][right] = res;
    return res;
  }

  private String s;
  private List<List<String>> ans;
  private int length;
  private char[] content;
  private LinkedList<String> middleResult;
}
