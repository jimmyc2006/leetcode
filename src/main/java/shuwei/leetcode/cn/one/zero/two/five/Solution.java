package shuwei.leetcode.cn.one.zero.two.five;

public class Solution {
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

    public boolean divisorGame1(int N) {
        if (N == 1){
            return false;
        }
        int[] f = new int[N + 1];
        // 1表示false,>1表示true
        f[0] = 2;
        f[1] = 1;
        return deal(N, f);
    }

    private boolean deal(int n, int[] f) {
        if(f[n] == 1) {
            return false;
        } else if (f[n] == 0) {
            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0){
                    if (!deal(n - i, f)){
                        f[n] = 2;
                        return true;
                    }
                    if (!deal(n - n / i, f)) {
                        f[n] = 2;
                        return true;
                    }
                }
            }
            f[n] = 1;
            return false;
        } else {
            return true;
        }
    }

    public boolean divisorGame3(int N) {
        if (N == 1){
            return false;
        }
        boolean[] f = new boolean[N + 1];
        f[1] = false;
        for (int i = 2; i <= N; i++) {
            if (!f[i - 1]) {
                f[i] = true;
                continue;
            }
            for (int j = 2; j <= i / 2; j++){
                if (i % j == 0){
                    if (!f[ i - i/j] || !f[i - j]){
                        f[i] = true;
                        break;
                    }
                }
            }
        }
        return f[N];
    }
}
