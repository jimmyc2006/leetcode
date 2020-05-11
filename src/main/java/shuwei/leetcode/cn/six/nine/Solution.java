package shuwei.leetcode.cn.six.nine;

public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.mySqrt(5));
  }

  // 二分查找
  public int mySqrt(int x) {
    if (x == 0) {
      return 0;
    }
    int start = 1;
    int end = x;
    while (true) {
      int middle = (end - start) / 2;
      if (middle == 0) {
        if (end <= x / end) {
          return end;
        } else {
          return start;
        }
      }
      int curr = start + middle;
      int tmp = x / curr;
      if (curr < tmp) {
        start = curr;
      } else if (curr == tmp) {
        return curr;
      } else {
        end = curr;
      }
    }
  }

  // 步长改为2,性能还是不好
  public int mySqrt2(int x) {
    if (x == 0) {
      return 0;
    }
    int i = 1;
    while (i <= x / i) {
      i = i + 2;
    }
    i = i - 1;
    if (i > x / i) {
      return i - 1;
    } else {
      return i;
    }
  }

  // 最基础的
  public int mySqrt1(int x) {
    int i = 1;
    while (i <= x / i) {
      i++;
    }
    return i - 1;
  }
}
