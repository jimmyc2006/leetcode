package shuwei.leetcode.cn.eight.six.zero;

public class Solution {


  private static final int fiveIndex = 0;
  private static final int tenIndex = 1;
  private static final int twentyIndex = 2;

  public boolean lemonadeChange(int[] bills) {
    int[] counts = new int[3];
    for (int ele : bills) {
      if (ele == 5) {
        counts[fiveIndex]++;
      } else if (ele == 10) {
        if (counts[fiveIndex] < 1) {
          return false;
        } else {
          counts[fiveIndex]--;
          counts[tenIndex]++;
        }
      } else {
        if (counts[tenIndex] > 0 && counts[fiveIndex] > 0) {
          counts[tenIndex]--;
          counts[fiveIndex]--;
        } else if (counts[fiveIndex] >= 3) {
          counts[fiveIndex] -= 3;
        } else {
          return false;
        }
      }
    }
    return true;
  }


}
