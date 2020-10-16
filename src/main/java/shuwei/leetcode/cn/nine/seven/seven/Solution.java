package shuwei.leetcode.cn.nine.seven.seven;

public class Solution {

  /**
   * 从两边往中间遍历，从大到小
   */
  public int[] sortedSquares(int[] A) {
    int[] ans = new int[A.length];
    int index = A.length - 1;
    int left = 0;
    int right = index;
    int leftSquare = A[left] * A[left];
    int rightSquare = A[right] * A[right];
    while (left < right) {
      if (leftSquare > rightSquare) {
        ans[index--] = leftSquare;
        left++;
        leftSquare = A[left] * A[left];
      } else {
        ans[index--] = rightSquare;
        right--;
        rightSquare = A[right] * A[right];
      }
    }
    ans[index] = rightSquare;
    return ans;
  }
}
