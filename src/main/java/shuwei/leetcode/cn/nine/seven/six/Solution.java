package shuwei.leetcode.cn.nine.seven.six;

import java.util.Arrays;

public class Solution {

  public int largestPerimeter(int[] A) {
    Arrays.sort(A);
    for (int i = A.length - 1; i >= 2; i--) {
      // 如果A[i - 2] + A[i -1]比A[i] 小于或者等于，那么后面就更不可能大于
      if (A[i - 2] + A[i - 1] > A[i]) {
        return A[i - 2] + A[i - 1] + A[i];
      }
    }
    return 0;
  }

  /**
   * 三角形必须满足两边之和大于第三边 先排序，然后固定两边，二分查找找第三条边
   */
  public int largestPerimeter1(int[] A) {
    Arrays.sort(A);
    int ans = 0;
    for (int i = A.length - 1; i >= 2; i--) {
      for (int j = i - 1; j >= 1; j--) {
        if (2 * A[j] + A[i] <= ans) {
          return ans;
        }
        for (int k = j - 1; k >= 0; k--) {
          if (A[k] <= A[i] - A[j]) {
            break;
          }
          if (A[k] + A[j] + A[i] > ans) {
            ans = A[k] + A[j] + A[i];
            break;
          } else {
            break;
          }
        }
      }
    }
    return ans;
  }

}
