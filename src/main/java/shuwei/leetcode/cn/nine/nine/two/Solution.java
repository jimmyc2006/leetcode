package shuwei.leetcode.cn.nine.nine.two;

public class Solution {

    public int subarraysWithKDistinct(int[] A, int K) {
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
     * @param A
     * @param K
     * @return
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
