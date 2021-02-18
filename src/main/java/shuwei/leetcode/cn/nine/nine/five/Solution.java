package shuwei.leetcode.cn.nine.nine.five;

public class Solution {

  /**
   * 从左往右变换
   */
  public int minKBitFlips(int[] A, int K) {
    int ans = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == 0) {
        if (A.length - i < K) {
          return -1;
        } else {
          ans++;
          for (int j = i; j < i + K; j++) {
            A[j] = A[j] ^ 1;
          }
        }
      }
    }
    return ans;
  }
}
