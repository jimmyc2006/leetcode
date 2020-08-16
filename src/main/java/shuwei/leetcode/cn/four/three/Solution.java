package shuwei.leetcode.cn.four.three;

public class Solution {
  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    int[] result = new int[num1.length() + num2.length()];
    char[] cs1 = num1.toCharArray();
    char[] cs2 = num2.toCharArray();
    for (int i = cs1.length - 1; i >= 0; i--) {
      for (int j = cs2.length - 1; j >= 0; j--) {
        int curRes = (cs1[i] - '0') * (cs2[j] - '0');
        result[i + j + 1] += curRes;
      }
    }
    StringBuilder finalResult = new StringBuilder();
    //  处理进位
    int remain = 0;
    for (int i = result.length - 1; i >= 0; i--) {
      int curTotal = result[i] + remain;
      if (i == 0 && curTotal == 0) {
        break;
      }
      finalResult.append(curTotal % 10);
      remain = curTotal / 10;
    }
    return finalResult.reverse().toString();
  }
}
