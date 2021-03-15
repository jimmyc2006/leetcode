package shuwei.leetcode.cn.five.seven.zero.one;

public class Solution {

  public boolean areAlmostEqual(String s1, String s2) {
    int diff1Index = -1;
    int diff2Index = -1;
    int diffCount = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (diffCount == 0) {
          diff1Index = i;
          diffCount++;
        } else if (diffCount == 1) {
          diff2Index = i;
          diffCount++;
        } else {
          return false;
        }
      }
    }
    if (diffCount == 0) {
      return true;
    } else if (diffCount == 1) {
      return false;
    } else {
      return s1.charAt(diff1Index) == s2.charAt(diff2Index) && s1.charAt(diff2Index) == s2.charAt(diff1Index);
    }
  }
}
