package shuwei.leetcode.cn.six.twow.eight;

public class Solution {

  /**
   * 注意这个有负数。。 那么结果可能是2个负数，1个正数，或者3个正数，那么保留最小的2个负数，最大的3个正数即可 还有可能正数不够3个，或者没正数
   * 如果没有正数，那么结果就是最大的三个数的成绩单 如果有1-2个正数，结果是最小的2个负数乘以最大的正数 如果有3个正数，那么就是3个正数相乘和最小的2个负数相乘再乘以最大的负数
   */
  public int maximumProduct(int[] nums) {
    boolean hasZero = false;
    int positiveCount = 0;
    int nagetiveCount = 0;
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    int max3 = Integer.MIN_VALUE;
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;
    int min3 = Integer.MAX_VALUE;
    for (int ele : nums) {
      if (ele > 0) {
        positiveCount++;
      } else if (ele < 0) {
        nagetiveCount++;
        if (ele < min3) {
          if (ele < min1) {
            min3 = min2;
            min2 = min1;
            min1 = ele;
          } else if (ele < min2) {
            min3 = min2;
            min2 = ele;
          } else {
            min3 = ele;
          }
        }
      } else {
        hasZero = true;
      }
      if (ele > max3) {
        if (ele > max1) {
          max3 = max2;
          max2 = max1;
          max1 = ele;
        } else if (ele > max2) {
          max3 = max2;
          max2 = ele;
        } else {
          max3 = ele;
        }
      }
    }
    if (positiveCount >= 3) {
      if (nagetiveCount >= 2) {
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
      } else {
        return max1 * max2 * max3;
      }
    } else if (positiveCount == 2) {
      if (nagetiveCount >= 2) {
        return min1 * min2 * max1;
      } else {
        if (hasZero) {
          return 0;
        } else {
          return max1 * max2 * min1;
        }
      }
    } else if (positiveCount == 1) {
      if (nagetiveCount >= 2) {
        return min1 * min2 * max1;
      } else {
        return 0;
      }
    } else {
      if (hasZero) {
        return 0;
      } else {
        return max1 * max2 * max3;
      }
    }
  }
}
