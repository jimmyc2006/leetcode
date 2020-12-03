package shuwei.leetcode.cn.two.zero.four;

public class Solution {

    public int countPrimes(int n) {
        int ans = 0;
        boolean[] isHeshu = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!isHeshu[i]) {
                ans++;
                kuozhan(i, n, isHeshu);
            }
        }
        return ans;
    }

    private void kuozhan(int start, int n, boolean[] isHeshu) {
        if ((long) start * start < n) {
            for (int i = start * start; i < n; i += start) {
                isHeshu[i] = true;
            }
        }
    }

    private boolean isZhishu(int n) {
        if (n <= 3) {
            return n > 1;
        }
        // 只有6x-1和6x+1的数才有可能是质数
        if (n % 6 != 1 && n % 6 != 5) {
            return false;
        }
        // 判断这些数能否被小于sqrt(n)的奇数整除
        int sqrt = (int) Math.sqrt(n);
        for (int i = 5; i <= sqrt; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
