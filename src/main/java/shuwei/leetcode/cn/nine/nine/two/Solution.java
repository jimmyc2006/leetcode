package shuwei.leetcode.cn.nine.nine.two;

public class Solution {

  public int subarraysWithKDistinct(int[] A, int K) {
    int ans = 0;
    int[] maxIndex = new int[A.length + 1];
    for (int i = 0; i < maxIndex.length; i++) {
      maxIndex[i] = -1;
    }
    int curr = 0;
    int start = 0, currCount = 0;
    for (int i = 0; i < A.length; i++) {
      if (maxIndex[A[i]] < start) {
        currCount++;
      }
      if (currCount == K) {
        ans++;
        curr++;
      }
      if (currCount > K) {
        // 从start往后找
        for (int j = start; j < i; j++) {
          if (maxIndex[A[j]] > j) {
            curr = curr > 1 ? curr - 1 : 1;
            ans += curr;
          } else {
            start = j + 1;
            currCount = K;
            curr = 1;
            ans++;
            break;
          }
        }
      }
      maxIndex[A[i]] = i;
    }
    if (currCount == K) {
      for (int j = start; j < A.length; j++) {
        if (maxIndex[A[j]] > j) {
          curr = curr > 1 ? curr - 1 : 1;
          ans += curr;
        }
      }
    }
    return ans;
  }

}
