package shuwei.leetcode.cn.nine.nine.two;

public class Solution {
  /**
   * 20210220 review 前后指针,普通的滑动窗口还是无法解决这种问题，因为每个开始位置都对应多个截止位置 所以改为求小于等于某个数值的自数组的个数，小于等于n - 小于等于(n -
   * 1),结果就是正好n 【1，2，1，2】从0到4的子数组应该是4-0=4个，从1到4的子数组是3个
   */
  public int subarraysWithKDistinct(int[] A, int K) {
    return cal2(A, K) - cal2(A, K - 1);
  }

  private int cal2(int[] A, int k) {
    int ans = 0;
    int length = A.length;
    int currDiffCount = 0;
    int left = 0;
    int[] counts = new int[length + 1];
    for (int i = 0; i < length; i++) {
      counts[A[i]]++;
      if (counts[A[i]] == 1) {
        currDiffCount++;
      }
      while (currDiffCount > k) {
        ans += i - left;
        counts[A[left]]--;
        if (counts[A[left]] == 0) {
          currDiffCount--;
        }
        left++;
      }
    }
    while (left < length) {
      ans += length - left;
      left++;
    }
    return ans;
  }


  public int subarraysWithKDistinct1(int[] A, int K) {
    return cal(A, K) - cal(A, K - 1);
  }

  int cal(int[] arr, int k) {
    int length = arr.length;
    int[] counts = new int[length + 1];
    int start = 0, end = 0, ans = 0, currCount = 0;
    while (end < length) {
      counts[arr[end]]++;
      if (counts[arr[end]] == 1) {
        currCount++;
      }
      while (currCount > k) {
        ans += end - start;
        counts[arr[start]]--;
        if (counts[arr[start]] == 0) {
          currCount--;
        }
        start++;
      }
      end++;
    }
    // 补充
    while (start < end) {
      ans += end - start;
      start++;
    }
    return ans;
  }

  /**
   * 比较精炼的方法，自己写的相同逻辑，会比较复杂,这个算法比较好
   */
  int atMostKDistinct(int[] A, int K) {
    int len = A.length;
    int[] freq = new int[len + 1];

    int left = 0;
    int right = 0;
    // [left, right) 里不同整数的个数
    int count = 0;
    int res = 0;
    // [left, right) 包含不同整数的个数小于等于 K
    while (right < len) {
      if (freq[A[right]] == 0) {
        count++;
      }
      freq[A[right]]++;
      right++;

      while (count > K) {
        freq[A[left]]--;
        if (freq[A[left]] == 0) {
          count--;
        }
        left++;
      }
      // [left, right) 区间的长度就是对结果的贡献
      res += right - left;
    }
    return res;
  }
}
