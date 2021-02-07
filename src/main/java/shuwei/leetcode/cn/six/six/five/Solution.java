package shuwei.leetcode.cn.six.six.five;

public class Solution {

  /**
   * 遇到不符合条件的，优先处理后面的，如果无法处理，再考虑修改前面的
   */
  public boolean checkPossibility(int[] nums) {
    if (nums.length <= 2) {
      return true;
    }
    boolean isChange = false;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i + 1] < nums[i]) {
        if (isChange) {
          return false;
        }
        isChange = true;
        if (i + 2 < nums.length) {
          // 可以通过修改 i + 1达到目标
          if (nums[i + 2] >= nums[i]) {
            i++;
            continue;
          } else {
            if (nums[i + 2] < nums[i + 1]) {
              return false;
            } else {
              // 可以通过修改i达到目标
              if (i - 1 < 0 || nums[i + 1] >= nums[i - 1]) {
                continue;
              } else {
                return false;
              }
            }
          }
        }
      }
    }
    return true;
  }
}
