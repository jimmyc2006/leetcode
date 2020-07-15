package shuwei.leetcode.cn.five.five;
/** 
* @author shuwei 
* @version 创建时间：2020年4月17日 上午9:22:18 
* 类说明 
*/
public class Solution1 {
  public boolean canJump(int[] nums) {
    if (nums.length <= 1) {
      return true;
    }
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0 && max <= i) {
        return false;
      }
      int stepMax = nums[i] + i;
      if (stepMax > max) {
        max = stepMax;
      }
      if (max >= nums.length - 1) {
        return true;
      }
    }
    // not reached
    return false;
  }
}
