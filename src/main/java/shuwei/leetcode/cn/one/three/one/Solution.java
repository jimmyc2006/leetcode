package shuwei.leetcode.cn.one.three.one;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<List<String>> partition(String s) {
    this.s = s;
    ans = new ArrayList<>();
    length = s.length();
    content = s.toCharArray();
    middleResult = new LinkedList();
    deal(0);
    return ans;
  }

  private void deal(int start) {
    if (start == length) {
      ans.add((List<String>) middleResult.clone());
    }
    for (int i = start + 1; i <= length; i++) {
      if (isHuiwen(start, i)) {
        middleResult.add(s.substring(start, i));
        deal(i);
        middleResult.removeLast();
      }
    }
  }

  private boolean isHuiwen(int left, int right) {
    for (int i = left, j = right - 1; i <= j ; i++, j--) {
      if (content[i] != content[j]) {
        return false;
      }
    }
    return true;
  }

  private String s;
  private List<List<String>> ans;
  private int length;
  private char[] content;
  private LinkedList<String> middleResult;
}
