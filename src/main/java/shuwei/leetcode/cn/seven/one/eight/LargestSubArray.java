package shuwei.leetcode.cn.seven.one.eight;

public class LargestSubArray {
    public int findLength(int[] A, int[] B) {
        // dp f[i][j] = f[i-1][j-1] + 1 or 0
        int[][] f = new int[A.length + 1][B.length + 1];
        int ans = 0;
        for (int i = 0; i< A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == A[j]) {
                    f[i + 1][j + 1] = f[i][j];
                    ans = Math.max(ans, f[i + 1][j +1]);
                } else {
                    f[i + 1][j + 1] = 0;
                }
            }
        }
        return ans;
    }
}
