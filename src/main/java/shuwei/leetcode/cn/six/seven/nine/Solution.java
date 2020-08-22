package shuwei.leetcode.cn.six.seven.nine;

public class Solution {
  /**
   * 思路：不考虑小括号的情况，采用暴力的方式，选择2个数进行一种运算，注意这2个数的顺序不同也是不一样的 然后4张变成了3张，然后再选2个数做运算，依次类推
   * 漏掉了n1 op (n2 op n3) op n4的情况 和 (n1 op n2) op (n3 op n4)
   * 可能还有一种算法是把能算出24点的数字的排列都先算出来然后跟输入比对？
   */

  public boolean judgePoint24(int[] nums) {
    return judge(nums);
  }

  private boolean judge(int[] nums) {
//    float result = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (j == i) {
          continue;
        }
        for (int o1 = 0; o1 < 4; o1++) {
          float result1 = cal(nums[i], nums[j], o1);
          for (int x = 0 ; x < 4; x++) {
            if (x == j || x == i) {
              continue;
            }
            for (int o2 = 0 ; o2 < 4; o2++) {
              float result2_1 = cal(result1, nums[x], o2);
              float result2_2 = cal(nums[x], result1, o2);
              for (int y = 0; y < 4; y++) {
                if (y == i || y == j || y == x) {
                  continue;
                }
                for (int o3 = 0; o3 < 4; o3++) {
                  if(isGood(cal(result2_1, nums[y], o3))){
                    return true;
                  }
                  if (isGood(cal(nums[y], result2_2, o3))) {
                    return true;
                  }
                  if(isGood(cal(result2_2, nums[y], o3))){
                    return true;
                  }
                  if (isGood(cal(nums[y], result2_2, o3))) {
                    return true;
                  }
                  float group2 = cal(nums[x], nums[y], o3);
                  for (int o4 = 0; o4 < 4; o4++) {
                    if(isGood(cal(result1, group2, o4))) {
                      return true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return false;
  }

  private float cal(float f1, float f2, int op) {
    switch (op) {
      case 0:
        return f1 + f2;
      case 1:
        return f1 - f2;
      case 2:
        return f1 * f2;
      case 3:
        return f1 / f2;
      default:
        throw new UnsupportedOperationException();
    }
  }
  private boolean isGood(float res) {
    if (diff(res, 24) < 0.001) {
      return true;
    } else {
      return false;
    }
  }
  private float diff(float f1, float f2) {
    if (f1 >= f2) {
      return f1 - f2;
    } else {
      return f2 - f1;
    }
  }
}
