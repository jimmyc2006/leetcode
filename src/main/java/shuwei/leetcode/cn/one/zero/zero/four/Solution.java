package shuwei.leetcode.cn.one.zero.zero.four;

public class Solution {

  public int longestOnes(int[] A, int K) {
    int length = A.length;
    int ans = 0, left = 0, right = 0;
    int remain = K;
    while (true) {
      if (length - left <= ans) {
        break;
      } else if (right == length) {
        ans = Math.max(ans, length - left);
        break;
      } else if (A[right] == 1) {
        right++;
      } else if (remain > 0) {
        remain--;
        right++;
      } else {
        ans = Math.max(ans, right - left);
        if (A[left++] == 0) {
          remain++;
        }
      }
    }
    return ans;
  }
}
