package shuwei.leetcode.cn.three.four.two;

public class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        int curr = 1;
        while (curr < n && curr > 0) {
            curr = curr << 2;
        }
        return curr == n;
    }
}
