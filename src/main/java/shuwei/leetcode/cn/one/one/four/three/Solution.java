package shuwei.leetcode.cn.one.one.four.three;

public class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
    char[] aCharArr = text1.toCharArray();
    char[] bCharArr = text2.toCharArray();
    int[][] f = new int[aCharArr.length + 1][bCharArr.length + 1];
    // 0代表第一个元素,f[aCharArr.length][bCharArr.length]为结果
    for (int i = 0; i < aCharArr.length; i++) {
      for (int j = 0; j < bCharArr.length; j++) {
        f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i + 1][j]);
        if (aCharArr[i] == bCharArr[j]) {
          f[i + 1][j + 1] = Math.max(f[i + 1][j + 1], f[i][j] + 1);
        }
      }
    }
    return f[aCharArr.length][bCharArr.length];
  }
}