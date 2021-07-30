package shuwei.leetcode.cn.one.seven.one;

public class Solution {
    public int titleToNumber(String columnTitle) {
        int currPow = 1;
        int ans = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            char c = columnTitle.charAt(i);
            ans += (c - 'A' + 1) * currPow;
            currPow *= 26;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.titleToNumber("A"));
        System.out.println(solution.titleToNumber("AB"));
        System.out.println(solution.titleToNumber("ZY"));
    }
}
