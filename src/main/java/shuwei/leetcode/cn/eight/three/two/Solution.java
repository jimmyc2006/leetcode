package shuwei.leetcode.cn.eight.three.two;

public class Solution {
  public int[][] flipAndInvertImage(int[][] A) {
    int x = A.length, y = A[0].length;
    for (int i = 0; i < x; i++) {
      int left = 0, right = y - 1;
      while (left < right) {
        int tmp = A[i][left];
        A[i][left] = A[i][right] ^ 1;
        A[i][right] = tmp ^ 1;
        left++;
        right--;
      }
      if (left == right) {
        A[i][left] = A[i][left] ^ 1;
      }
    }
    return A;
  }
}
