package shuwei.leetcode.cn.match.m0830;

public class Two {

  /**
   * 先把0取出来，并且计算以0分割的各段的负数的个数，以及第一个和最后一个负数的索引
   */
  public int getMaxLen(int[] nums) {
    int ans = 0;
    // 0是开始位置，1是负数开始位置，2是截止负数位置，3是段截止位置
    int start = 0, firstZero = 0, lastZero = 0;
    boolean hasFz = false;
    boolean isPositive = true;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        if(!hasFz) {
          firstZero = i;
          hasFz = true;
        }
        lastZero = i;
        isPositive = !isPositive;
      } else if (nums[i] == 0) {
        if (isPositive) {
          ans = Math.max(ans, i - start);
        } else {
          ans = Math.max(lastZero - start, ans);
          ans = Math.max(ans, i - firstZero - 1);
        }
        hasFz = false;
        start = i + 1;
        isPositive = true;
      }
    }
    // 处理最后
    if (nums[nums.length - 1] != 0) {
      if (isPositive) {
        ans = Math.max(ans, nums.length - start);
      } else {
        ans = Math.max(lastZero - start, ans);
        ans = Math.max(ans, nums.length - firstZero - 1);
      }
    }
    return ans;
  }

}
