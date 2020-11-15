package shuwei.leetcode.cn.four.zero.two;

public class Solution {

  /**
   * 有一种情况是删除某几个数以后，会出现前导0 从左边往右边数k+1个数，如果其中有0，说明可以出现前导0，那么优先删除能造成前导0的数
   * 当没有前导0的时候，从某个数中删除k个数，直接删除最大的几个数值即可
   */
  public String removeKdigits(String num, int k) {
    if (num.length() == k) {
      return "0";
    }
    return deleteOther(num, k);
  }

  private String deleteOther(String num, int k) {
    StringBuilder sb = new StringBuilder(num);
    int index = 0;
    while (k > 0 && index + 1 < sb.length()) {
      if (sb.charAt(index) > sb.charAt(index + 1)) {
        sb.deleteCharAt(index);
        index = Math.max(0, index - 1);
        k--;
      } else {
        index++;
      }
    }
    while (k > 0) {
      // 删除最后几位
      sb.deleteCharAt(sb.length() - 1);
      k--;
    }
    while (sb.length() > 0 && sb.charAt(0) == '0') {
      sb.deleteCharAt(0);
    }
    return sb.length() > 0 ? sb.toString() : "0";
  }
}
