package shuwei.leetcode.cn.four.five.four;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    int length = A.length;
    if (length < 1) {
      return 0;
    }
    Arrays.sort(C);
    Arrays.sort(D);
    int ans = 0;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        int need = -(A[i] + B[j]);
        for (int c = 0, d = length - 1; c < length && d >= 0; ) {
          int sum = C[c] + D[d];
          if (sum > need) {
            d--;
          } else if (sum < need) {
            c++;
          } else {
            int cc = 1;
            int dd = 1;
            while (c + 1 < length && C[c + 1] == C[c]) {
              c++;
              cc++;
            }
            while (d - 1 >= 0 && D[d] == D[d - 1]) {
              d--;
              dd++;
            }
            ans += cc * dd;
//            System.out.println(A[i] + ":" + B[j] + ":" + C[c] + ":" + D[d] + " -> " + cc * dd);
            if (c + 1 < length) {
              c++;
              continue;
            }
            if (d - 1 >= 0) {
              d--;
              continue;
            }
            c++;
          }
        }
      }
    }
    return ans;
  }

  public int test(int[] A, int[] B, int[] C, int[] D) {
    int ans = 0;
    int length = A.length;
    for (int a = 0; a < length; a++) {
      for (int b = 0; b < length; b++) {
        for (int c = 0; c < length; c++) {
          for (int d = 0; d < length; d++) {
            if (A[a] + B[b] + C[c] + D[d] == 0) {
              System.out.println(A[a] + ":" + B[b] + ":" + C[c] + ":" + D[d]);
              ans++;
            }
          }
        }
      }
    }
    return ans;
  }

  public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
    Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
    for (int u : A) {
      for (int v : B) {
        countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
      }
    }
    int ans = 0;
    for (int u : C) {
      for (int v : D) {
        if (countAB.containsKey(-u - v)) {
          int aaa = countAB.get(-u - v);
          ans += aaa;
        }
      }
    }
    return ans;
  }

}