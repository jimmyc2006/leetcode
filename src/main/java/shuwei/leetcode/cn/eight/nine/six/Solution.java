package shuwei.leetcode.cn.eight.nine.six;

public class Solution {
  public boolean isMonotonic(int[] A) {
    if (A.length == 1) {
      return true;
    }
    Boolean isBigger = null;
    for (int i = 1; i < A.length; i++) {
      if (A[i] > A[i- 1]) {
        if(isBigger == null) {
          isBigger = true;
        } else if (!isBigger) {
          return false;
        }
      } else if (A[i] < A[i - 1]) {
        if (isBigger == null) {
          isBigger = false;
        } else if (isBigger) {
          return false;
        }
      }
    }
    return true;
  }
}
