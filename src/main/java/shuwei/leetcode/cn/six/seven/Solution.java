package shuwei.leetcode.cn.six.seven;

public class Solution {
    public String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int remain = 0;
        for (int i = aChars.length - 1, j = bChars.length - 1; i >= 0 || j >= 0;) {
            if (i >= 0){
                remain += aChars[i] - '0';
                i--;
            }
            if (j >= 0) {
                remain += bChars[j] - '0';
                j--;
            }
            sb.append(remain % 2);
            remain = remain / 2;
        }
        if (remain > 0) {
            sb.append(remain);
        }
        return sb.reverse().toString();
    }
}
