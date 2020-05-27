package shuwei.leetcode.cn.nine.seven.four;

public class Solution {
  // 采用前缀和对5求余的方法
  public int subarraysDivByK(int[] A, int K) {
    int[] preSum = new int[K];
    preSum[0] = 1;
    int sum = 0;
    int ans = 0;
    for (int i = 0; i < A.length; i++) {
      sum += A[i];
      sum = sum % K;
      if (sum < 0) {
        sum = sum + K;
      }
      ans += preSum[sum]++;
    }
    return ans;
  }
}
