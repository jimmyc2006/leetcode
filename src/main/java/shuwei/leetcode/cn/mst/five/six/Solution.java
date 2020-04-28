package shuwei.leetcode.cn.mst.five.six;

public class Solution {
  
  public int[] singleNumbers(int[] nums) {
    int allYH = 0;
    for (int i = 0; i < nums.length; i++) {
      allYH = allYH ^ nums[i];
    }
    int sum = 1;
    while (true) {
      if ((allYH & sum) > 0) {
        break;
      }
      sum = sum << 1;
    }
    int x1 = 0;
    int x2 = 0;
    for (int i = 0; i < nums.length; i++) {
      if ((nums[i] & sum) == 0) {
        x1 = x1 ^ nums[i];
      } else {
        x2 = x2 ^ nums[i];
      }
    }
    return new int[] {x1, x2};
  }
}