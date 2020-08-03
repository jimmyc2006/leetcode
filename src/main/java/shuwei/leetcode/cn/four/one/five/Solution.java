package shuwei.leetcode.cn.four.one.five;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder(num1.length() > num2.length() ? num1.length() : num2.length());
    char[] c1 = num1.toCharArray();
    char[] c2 = num2.toCharArray();
    int remain = 0;
    int i = c1.length - 1;
    int j = c2.length - 1;
    while (true){
      int n = 0;
      if (i >= 0 && j >= 0) {
        n = (c1[i] - '0') + (c2[j] - '0') + remain;
        i--;
        j--;
      } else if(i >= 0) {
        n = c1[i] - '0' + remain;
        i--;
      } else if(j >= 0) {
        n = c2[j] - '0' + remain;
        j--;
      } else {
        break;
      }
      sb.append(Integer.toString(n % 10));
      remain = n / 10;
    }
    if (remain >0 ) {
      sb.append(Integer.toString(remain));
    }
    return sb.reverse().toString();
  }
}
