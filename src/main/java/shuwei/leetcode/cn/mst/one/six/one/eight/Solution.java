package shuwei.leetcode.cn.mst.one.six.one.eight;

import com.sun.javafx.collections.IntegerArraySyncer;

import java.util.Map;

public class Solution {
    public boolean patternMatching(String pattern, String value) {
        char[] patChars = pattern.toCharArray();
        char[] valChars = value.toCharArray();
        int[] patCount = count(patChars);
        return false;
    }

    private boolean isMatch(String value, char[] pattern, int[] patCount) {
        if (patCount[0] == 0 && patCount[1] == 0){
            return value.length() < 1;
        }
        if (patCount[0] == 1 || patCount[1] == 1) {
            return true;
        }

        if (patCount[0] == 0) {

        } else {

        }
        // 计算a和b的长度：acount * aLength + bCount * bLength = value.length
        // 从0开始枚举a的长度
        for (int i = 0; i <= value.length / ) {

        }
    }

    private boolean isM(String value, int length, ) {

    }

    private int[] count(char[] content) {
        int[] count = new int[2];
        for (char c : content) {
            count[c - 'a']++;
        }
        return count;
    }
}
