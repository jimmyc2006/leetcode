package shuwei.leetcode.cn.one.three.five.six;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
  public int[] sortByBits(int[] arr) {
    if (arr.length < 2) {
      return arr;
    }
    Integer[] res = new Integer[arr.length];
    for (int i = 0; i < arr.length; i++) {
      res[i] = arr[i];
    }
    Arrays.sort(res, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
          int oneCount1 = this.getOneCount(o1);
          int oneCount2 = this.getOneCount(o2);
          if (oneCount1 > oneCount2) {
            return 1;
          } else if (oneCount1 < oneCount2) {
            return -1;
          } else {
            return o1 - o2;
          }
      }
      private int getOneCount(int num) {
        return Integer.bitCount(num);
      }
    });
    for (int i = 0 ; i < res.length; i++) {
      arr[i] = res[i];
    }
    return arr;
  }

}
