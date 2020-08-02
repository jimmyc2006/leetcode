package shuwei.leetcode.cn.zero.right.zero.three;

public class Solution {

  public int findMagicIndex(int[] nums) {
    int index = 0;
    while (nums[index] != index) {
      if (nums[index] > index) {
        index = nums[index];
        if (index >= nums.length) {
          return -1;
        }
      } else {
        index++;
      }
    }
    return index;
  }

}
