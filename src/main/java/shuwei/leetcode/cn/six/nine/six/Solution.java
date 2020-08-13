package shuwei.leetcode.cn.six.nine.six;

public class Solution {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int ans = 0;
        char[] content = s.toCharArray();
        int left = 0, right = 1;
        char last = content[0];
        for (int i = 1; i < content.length; i++) {
            if (content[i] == last){
                right++;
            } else {
                // 变化
                last = content[i];
                left = right;
                right = 1;
            }
            if (right <= left){
                ans++;
            }
        }
        return ans;
    }
}
