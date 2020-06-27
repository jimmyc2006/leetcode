package shuwei.leetcode.cn.bs3;

public class Solution {
  public int longestSubarray(int[] nums) {
    boolean hasZero = false;
    int lastZero = -1;
    int ans = 0;
    int count = 0;
    int start = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        count++;
      } else {
        hasZero = true;
        if (count == 0) {
          start = i + 1;
          continue;
        }
        if (lastZero == -1) {
          lastZero = i;
        } else {
          ans = Math.max(ans, count);
          count = count - (lastZero - start);
          if (count == 0) {
            start = i + 1;
            lastZero = -1;
          } else {
            start = lastZero + 1;
            lastZero = i;
          }
        }
      }
    }
    ans = Math.max(ans, count);
    if (hasZero) {
      return ans;
    } else {
      return ans == 0 ? 0 : ans - 1;
    }
  }
}
