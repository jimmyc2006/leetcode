package shuwei.leetcode.cn.nine.nine.five;

public class Solution {
  /**
   * 采用题解中的方法，记录每个数反转的次数
   * @param A
   * @param K
   * @return
   */
  public int minKBitFlips(int[] A, int K) {
    int length = A.length;
    int ans = 0;
    int reverse = 0;
    int[] reverseCount = new int[length + 1];
    for (int i = 0; i < length; i++) {
      reverse += reverseCount[i];
      if ((reverse & 1) == 1) {
        A[i] = (A[i] ^ 1);
      }
      if (A[i] == 0) {
        if (length - i < K) {
          return -1;
        }
        ans++;
        reverse++;
        if (i + K < length) {
          reverseCount[i + K]--;
        }
      }
    }
    return ans;
  }

  /**
   * 从左往右变换，if语句无法通过，按位异或通过了
   */
//  public int minKBitFlips(int[] A, int K) {
//    int ans = 0;
//    for (int i = 0; i < A.length; i++) {
//      if (A[i] == 0) {
//        if (A.length - i < K) {
//          return -1;
//        } else {
//          ans++;
//          for (int j = i; j < i + K; j++) {
//            A[j] = A[j] ^ 1;
//          }
//        }
//      }
//    }
//    return ans;
//  }
}
