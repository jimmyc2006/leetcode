package shuwei.leetcode.cn.three.three.eight;

import java.util.Arrays;

public class Solution {
  private int[] ans = new int[]{0};

  public int[] countBits(int num) {
    if (ans.length > num) {
      return Arrays.copyOfRange(ans, 0, num + 1);
    }
    int[] tmp = Arrays.copyOf(ans, num + 1);
    for (int i = ans.length; i <= num; i++) {
      tmp[i] = Integer.bitCount(i);
    }
    ans = tmp;
    return ans;
  }
}
