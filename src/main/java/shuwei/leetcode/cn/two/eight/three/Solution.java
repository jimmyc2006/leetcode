package shuwei.leetcode.cn.two.eight.three;

public class Solution {

  /**
   * 不使用额外数组的话，从前往后遍历，遇到0，有个index停止，另一个往后走，遇到非0就交换
   * 这种算法应该不会太快
   * @param nums
   */
  public void moveZeroes(int[] nums) {
    if (nums.length < 2) {
      return;
    }
    int lastZero = -1;
    int current = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        if (lastZero < 0) {
          lastZero = i;
        }
      } else {
        if (lastZero >= 0) {
          nums[lastZero] = nums[i];
          nums[i] = 0;
          int j = lastZero + 1;
          lastZero = -1;
          while (j <= i) {
            if (nums[j] == 0) {
              lastZero = j;
              break;
            }
            j++;
          }
        }
      }
    }
  }

}
