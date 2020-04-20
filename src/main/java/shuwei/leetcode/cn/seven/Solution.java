package shuwei.leetcode.cn.seven;

/**
 * @author shuwei
 * @version 创建时间：2020年4月16日 下午7:28:40 类说明
 */
public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.reverse(1534236469));
    System.out.println(s.reverse(123));
    System.out.println(s.reverse(-123));
  }

  public int reverse(int x) {
    if (x < 0) {
      return rev(x * -1) * -1;
    } else {
      return rev(x);
    }
  }

  public int rev(int x) {
    int result = 0;
    while (x > 0) {
      int tmp = x % 10;
      x = x / 10;
      result = result * 10 + tmp;
      if (x > 0 && (Integer.MAX_VALUE - (x % 10)) / 10 < result) {
        return 0;
      }
    }
    return result;
  }
}
