package shuwei.leetcode.cn.one.two.zero.two;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  
  public boolean isHappy(int n) {
    Set<Integer> s = new HashSet<>();
    while (n > 1) {
      if (s.contains(n)) {
        return false;
      }
      s.add(n);
      int tmpResult = 0;
      while (n > 0) {
        int tmp = n % 10;
        tmp = tmp * tmp;
        tmpResult += tmp;
        n = n / 10;
      }
      n = tmpResult;
    }
    return true;
  }
  
}
