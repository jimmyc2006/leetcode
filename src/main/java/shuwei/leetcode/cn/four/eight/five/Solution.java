package shuwei.leetcode.cn.four.eight.five;

public class Solution {

  public int findMaxConsecutiveOnes(int[] nums) {
    int ans = 0, curr = 0;
    for (int num : nums) {
      if (num == 1) {
        curr++;
      } else {
        ans = Math.max(ans, curr);
        curr = 0;
      }
    }
    return Math.max(ans, curr);
  }

}
