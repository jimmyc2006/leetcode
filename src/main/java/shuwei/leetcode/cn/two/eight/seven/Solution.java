package shuwei.leetcode.cn.two.eight.seven;

public class Solution {
  // 看了官方的第一个解题思路
  public int findDuplicate(int[] nums) {
    int start = 1;
    int end = nums.length - 1;
    int mid = 0;
    while (true) {
      mid = start + (end - start + 1) / 2;
      int count = 0;
      for (int e : nums) {
        if (e < mid) {
          count++;
        }
      }
      if (count < mid) {
        if (end == mid) {
          return end;
        }
        start = mid;
      } else {
        if (end == mid) {
          return start;
        }
        end = mid;
      }
    }
  }
}
