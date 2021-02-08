package shuwei.leetcode.cn.nine.seven.eight;

public class Solution {
  public int maxTurbulenceSize(int[] arr) {
    if (arr.length == 1) {
      return 1;
    }
    int start = 0;
    Boolean needBigger = null;
    int ans = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > arr[i - 1]) {
        if (needBigger == null || !needBigger) {
          if (needBigger != null) {
            ans = Math.max(ans, i - start);
          }
          start = i - 1;
        }
        needBigger = false;
      } else if (arr[i] == arr[i - 1]) {
        if (needBigger != null) {
          ans = Math.max(ans, i - start);
        }
        needBigger = null;
      } else {
        if (needBigger == null || needBigger) {
          if (needBigger != null) {
            ans = Math.max(ans, i - start);
          }
          start = i - 1;
        }
        needBigger = true;
      }
    }
    if (needBigger != null) {
      return Math.max(ans, arr.length - start);
    }
    return ans;
  }
}
