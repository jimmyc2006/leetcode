package shuwei.leetcode.cn.one.one.five;

public class Solution {

  public int numDistinct(String s, String t) {
    if (s.length() < 1) {
      return 0;
    }
    int sLength = s.length();
    int tLength = t.length();
    int[][] f = new int[sLength][tLength];
    // 先算一下最后一个字母
    int currCount = 0;
    int index = tLength - 1;
    int findChar = t.charAt(index);
    for (int i = sLength - 1; i >= 0; i--) {
      if (s.charAt(i) == findChar) {
        currCount++;
      }
      f[i][index] = currCount;
    }
    for (int i = t.length() - 2; i >= 0; i--) {
      currCount = 0;
      findChar = t.charAt(i);
      for (int j = s.length() - 2; j >= 0; j--) {
        if (s.charAt(j) == findChar) {
          currCount += f[j + 1][i + 1];
        }
        f[j][i] = currCount;
      }
    }
    return f[0][0];
  }
}
