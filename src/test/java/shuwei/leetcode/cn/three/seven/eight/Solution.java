package shuwei.leetcode.cn.three.seven.eight;

public class Solution {

  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    int start = matrix[0][0], end = matrix[n- 1] [n - 1];
    while (start < end) {
      int mid = (start + end) / 2;
      int lettleCount = littleCount(matrix, mid, n);
      if (lettleCount < k) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    return start;
  }

  private int littleCount(int[][] matrix, int num, int n) {
    int i = n - 1, j = 0;
    int count = 0;
    while (i >= 0 && j < n) {
      if (matrix[i][j] <= num) {
        count += i + 1;
        j++;
      } else {
        i--;
      }
    }
    return count;
  }
}
