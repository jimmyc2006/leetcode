package shuwei.leetcode.cn.five.one;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<List<String>> solveNQueens(int n) {
    this.n = n;
    status = new boolean[n];
    data = new boolean[n][n];
    ans = new ArrayList<>();
    deal(0);
    return ans;
  }

  private int n;
  private boolean[] status;
  private boolean[][] data;
  List<List<String>> ans;

  private void deal(int index) {
    if (index == n) {
      ans.add(this.genResult());
      return;
    }
    for (int i = 0; i < n; i++) {
      if ((!status[i]) && isValid(index, i)) {
        // 这列已经有棋子
        status[i] = true;
        data[index][i] = true;
        deal(index + 1);
        status[i] = false;
        data[index][i] = false;
      }
    }
  }

  private boolean isValid(int x, int y) {
    int i = x, j = y;
    while ((--i >= 0) && (--j >= 0)) {
      if (data[i][j]) {
        return false;
      }
    }
    i = x;
    j = y;
    while((++i < n) && (++j < n)) {
      if (data[i][j]) {
        return false;
      }
    }
    i = x;
    j = y;
    while((--i >= 0) && (++j < n)) {
      if (data[i][j]) {
        return false;
      }
    }
    i = x;
    j = y;
    while((++i < n) && (--j >= 0)) {
      if (data[i][j]) {
        return false;
      }
    }
    return true;
  }

  private List<String> genResult() {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (data[i][j]) {
          sb.append('Q');
        } else {
          sb.append('.');
        }
      }
      result.add(sb.toString());
      sb.delete(0, sb.length());
    }
    return result;
  }

}
