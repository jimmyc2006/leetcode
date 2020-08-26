package shuwei.leetcode.cn.six.seven.nine;

public class Solution {
  /**
   * 从n个数值里面取出2个数进行计算，然后将这个计算结果与剩下的n-2个数进行排列
   *
   * 官方精粹：same
   */
  public boolean judgePoint24(int[] nums) {
    float[] data = new float[nums.length];
    for (int i = 0; i < nums.length; i++) {
      data[i] = nums[i];
    }
    return judge(data);
  }

  private boolean judge(float[] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        // 计算这两个数的值
        float[] twoCalResult = cal2Num(nums[i], nums[j]);
        if (nums.length == 2) {
          for (float res : twoCalResult) {
            if (isSame(res, 24)) {
              return true;
            }
          }
          return false;
        }
        float[] nexts = new float[nums.length - 1];
        int index = 0;
        for (int x = 0; x < nums.length; x++) {
          if (x != i && x != j) {
            nexts[index++] = nums[x];
          }
        }
        for (int k = 0; k < twoCalResult.length; k++) {
          nexts[index] = twoCalResult[k];
          if (judge(nexts)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  // 将两个数进行计算，然后返回
  private float[] cal2Num(float f1, float f2) {
    int length = 4;
    if (!isSame(f1, 0)) {
      length++;
    }
    if (!isSame(f2, 0)) {
      length++;
    }
    float[] result = new float[length];
    int index = 0;
    result[index++] = f1 + f2;
    result[index++] = f1 * f2;
    result[index++] = f1 - f2;
    result[index++] = f2 - f1;
    if (!isSame(f1, 0)) {
      result[index++] = f2 / f1;
    }
    if (!isSame(f2, 0)) {
      result[index++] = f1 / f2;
    }
    return result;
  }

  private boolean isSame(float f1, float f2) {
    float res = f1 - f2;
    if (res < 0.0001 && res > -0.0001) {
      return true;
    }
    return false;
  }
}
