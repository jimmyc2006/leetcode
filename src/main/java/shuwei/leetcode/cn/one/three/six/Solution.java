package shuwei.leetcode.cn.one.three.six;

public class Solution {
  // 跟shuwei.leetcode.cn.mst.five.six类似
  public int singleNumber(int[] nums) {
    int result = nums[0];
    for (int i = 1; i < nums.length; i++) {
      result = result ^ nums[i];
    }
    return result;
  }
}
