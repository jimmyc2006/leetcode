package shuwei.leetcode.cn.nine.six;

public class Solution {
    public int numTrees(int n) {
        if (n <= 2) {
            return n;
        }
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++){
            f[i] = 2 * f[i - 1];
            int j = 0;
            for (j = 1; j < i / 2; j++) {
                f[i] += 2 * f[j] * f[i - 1 - j];
            }
            if (i % 2 == 1) {
                f[i] += f[i / 2] * f[i / 2];
            }
        }
        return f[n];
    }
}
