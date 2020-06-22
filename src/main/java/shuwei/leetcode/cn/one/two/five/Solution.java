package shuwei.leetcode.cn.one.two.five;

public class Solution {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            int  t1 = this.transChar(chars, i);
            while (t1 == INVALID && i < j) {
                i++;
                t1 = this.transChar(chars, i);
            }
            int t2 = this.transChar(chars, j);
            while (t2 == INVALID && i < j) {
                j--;
                t2 = this.transChar(chars, j);
            }
            if (i < j && t1 != t2) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private static final char INVALID = '-';
    private int transChar(char[] chars, int index) {
        if (chars[index] >= '0' && chars[index] <= '9') {
            return chars[index];
        } else if (chars[index] >= 'a' && chars[index] <= 'z') {
            return chars[index];
        } else if (chars[index] >= 'A' && chars[index] <= 'Z') {
            return 'a' + chars[index] - 'A';
        } else {
            return INVALID;
        }
    }
}
