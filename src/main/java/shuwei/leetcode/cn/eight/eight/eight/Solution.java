package shuwei.leetcode.cn.eight.eight.eight;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int[] fairCandySwap(int[] A, int[] B) {
    if (A.length > B.length) {
      int[] res = cal(A, B);
      return new int[]{res[1], res[0]};
    } else {
      return cal(B, A);
    }
  }

  private int[] cal(int[] _long, int[] _short) {
    int sumL = 0;
    Map<Integer, Integer> value2Index = new HashMap<>();
    for (int i = 0; i < _long.length; i++) {
      sumL += _long[i];
      value2Index.put(_long[i], i);
    }
    int sumS = 0;
    for (int ele : _short) {
      sumS += ele;
    }
    if (sumL >= sumS) {
      int diff = (sumL - sumS) / 2;
      for (int ele : _short) {
        int find = ele + diff;
        if (value2Index.get(find) != null) {
          return new int[]{ele, find};
        }
      }
    } else {
      int diff = (sumS - sumL) / 2;
      for (int ele : _short) {
        int find = ele - diff;
        if (value2Index.get(find) != null) {
          return new int[]{ele, find};
        }
      }
    }
    return  null;
  }
}
