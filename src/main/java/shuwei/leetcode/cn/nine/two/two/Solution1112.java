package shuwei.leetcode.cn.nine.two.two;

public class Solution1112 {
  /**
   * 两个索引遍历，一个遍历奇数下标，一个遍历偶数下标
   * @param A
   * @return
   */
  public int[] sortArrayByParityII(int[] A) {
    for (int i = 0, j = 1; i < A.length && j < A.length;) {
      if (A[i] % 2 == 0) {
        i += 2;
      } else if (A[j] % 2 == 1) {
        j += 2;
      } else {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
        i += 2;
        j += 2;
      }
    }
    return A;
  }
}
