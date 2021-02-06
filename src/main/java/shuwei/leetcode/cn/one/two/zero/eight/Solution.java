package shuwei.leetcode.cn.one.two.zero.eight;

public class Solution {

    public int equalSubstring(String s, String t, int maxCost) {
        if (maxCost == 0) {
            return this.dealZero(s, t);
        }
        int ans = 0, start = 0, curr = 0;
        int remain = maxCost;
        while (curr < s.length()) {
            int cost = Math.abs(s.charAt(curr) - t.charAt(curr));
            if (cost <= remain) {
                remain -= cost;
                curr++;
            } else {
                ans = Math.max(ans, curr - start);
                if (start == curr) {
                    remain = maxCost;
                    start++;
                    curr++;
                } else {
                    remain += Math.abs(s.charAt(start) - t.charAt(start));
                    start++;
                }
            }
        }
        // 最后一个
        if (curr == s.length()) {
            return Math.max(ans, curr - start);
        } else {
            return ans;
        }
    }

    private int dealZero(String s, String t){
        int ans = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (start >= 0) {
                    ans = Math.max(ans, i - start);
                }
                start = -1;
            } else {
                if (start == -1){
                    start = i;
                }
            }
        }
        if (start != -1) {
            return Math.max(ans, s.length() - start);
        } else {
            return ans;
        }
    }
}
