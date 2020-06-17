package shuwei.leetcode.cn.one.four;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(true) {
            if (i >= strs[0].length()) {
                return sb.toString();
            }
            char tmp = strs[0].charAt(i);
            for (int k = 1; k < strs.length; k++) {
                if (i >= strs[k].length() || strs[k].charAt(i) != tmp) {
                    return sb.toString();
                }
            }
            sb.append(tmp);
            i++;
        }
    }
}
