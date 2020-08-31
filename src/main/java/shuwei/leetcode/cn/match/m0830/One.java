package shuwei.leetcode.cn.match.m0830;

public class One {
  // 暴力计算
  public boolean containsPattern(int[] arr, int m, int k) {
    if (m * k > arr.length) {
      return false;
    }
    if (k == 1 && arr.length > 0) {
      return true;
    }
    for (int i = 0; i < arr.length - m; i++) {
      if (judge(i, i + m - 1, arr, k)) {
        return true;
      }
    }
    return false;
  }

  private boolean judge(int start, int end, int[] arr, int k) {
    int repeats = 1;
    if (start == end) {
      for (int i = end + 1; i < arr.length; i++) {
        if (arr[i] == arr[end]) {
          repeats++;
          if (repeats >= k) {
            return true;
          }
        } else {
          return false;
        }
      }
    } else {
      for (int i = end + 1, j = start; i < arr.length; i++) {
        if (arr[i] == arr[j]) {
          j++;
          if (j > end) {
            repeats++;
            if (repeats >= k) {
              return true;
            }
            j = start;
          }
        } else {
          return false;
        }
      }
    }
    return false;
  }
}
