package shuwei.leetcode.cn.mst.one.six.one.eight;

import com.sun.javafx.collections.IntegerArraySyncer;

import java.util.Map;

public class Solution {

    public boolean patternMatching(String pattern, String value) {
        char[] patChars = pattern.toCharArray();
        int[] patCount = count(patChars);
        return isMatch(value, patChars, patCount);
    }

    private boolean isMatch(String value, char[] pattern, int[] patCount) {
        if (value.length() < 1 && patCount[0] > 0 && patCount[1] > 0) {
            return false;
        }
        if (patCount[0] == 1 || patCount[1] == 1) {
            return true;
        }
        if (patCount[0] == 0 && patCount[1] == 0){
            return value.length() < 1;
        }

        if (patCount[0] == 0 || patCount[1] == 0) {
            return this.isMatchOne(value, pattern.length);
        }
        return isMatchTwo(value, pattern, patCount);
    }

    private boolean isMatchTwo(String value, char[] pattern, int[] patCount) {
        // a.length * patCount[0] + b.length * patCount[1] = value.length
        for (int i = 0; i <= value.length() / patCount[0]; i++) {
            int aLength = i;
            int totalLengthA = aLength * patCount[0];
            if ((value.length() - totalLengthA) % patCount[1] != 0) {
                continue;
            }
            int bLength = (value.length() - totalLengthA) / patCount[1];
            if (isMatchTwo(value, pattern, aLength, bLength)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatchTwo(String value, char[] pattern, int aLength, int bLength) {
        int start = 0;
        String aStr = null, bStr = null;
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == 'a') {
                if (aStr == null) {
                    aStr = value.substring(start, start + aLength);
                } else {
                    if (!aStr.equals(value.substring(start, start + aLength))) {
                        return false;
                    }
                }
                start += aLength;
            } else {
                if (bStr == null) {
                    bStr = value.substring(start, start + bLength);
                } else {
                   if (!bStr.equals(value.substring(start, start + bLength))) {
                        return false;
                   }
                }
                start += bLength;
            }
            if (aStr != null && bStr != null && aStr.equals(bStr)) {
                return false;
            }
        }
        return true;
    }

    private boolean isMatchOne(String value, int length) {
        if (value.length() % length != 0 || value.length() < length) {
            return false;
        }
        String pat = value.substring(0, length);
        int start = length;
        while (start < value.length()) {
            if (!pat.equals(value.substring(start, start + length))) {
                return false;
            }
            start = start + length;
        }
        return true;
    }

    private int[] count(char[] content) {
        int[] count = new int[2];
        for (char c : content) {
            count[c - 'a']++;
        }
        return count;
    }
}
