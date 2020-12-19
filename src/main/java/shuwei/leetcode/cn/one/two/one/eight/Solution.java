package shuwei.leetcode.cn.one.two.one.eight;

public class Solution {

    public char findTheDifference(String s, String t) {
        int[] countsS = arr(s);
        int[] countsT = arr(t);
        for (int i = 0; i < countsS.length; i++) {
            if (countsT[i] > countsS[i]) {
                return (char) (i + 'a');
            }
        }
        throw new RuntimeException("none ans");
    }

    private int[] arr(String s) {
        char[] chars = s.toCharArray();
        int[] counts = new int[26];
        for (char ele : chars) {
            counts[ele - 'a']++;
        }
        return counts;
    }
}
