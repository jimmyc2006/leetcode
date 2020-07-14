package shuwei.leetcode.cn.four.six.six;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
  public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
    // 先找规律，算出几个s1里包含几个s2
    LinkedHashMap<Integer, int[]> endMatch = new LinkedHashMap<>();
    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();
    int curr = 0, c1Count = 1, c2Count = 0;
    int c1N = 0, // 多少个c1对应
            c2N = 0, // 多少个c2
            c1Head = 0, c2Head = 0; // 出现环之前匹配的几个c2
    int circleStart = 0;
    for (int i = 0; ; ) {
      if (c1[i] == c2[curr]) {
        if (curr == c2.length - 1) {
          c2Count++;
          curr = 0;
          int[] val = endMatch.get(i);
          if (val != null) {
            // 找到重复,从某个点开始，经过c1Count个匹配c2Count个c2
            c1N = c1Count - val[0];
            c2N = c2Count - val[1];
            c1Head = val[0];
            c2Head = val[1];
            circleStart = i;
            break;
          }
          endMatch.put(i, new int[]{c1Count, c2Count});

        } else {
          curr++;
        }
      }
      if (i == c1.length - 1) {
        i = 0;
        c1Count++;
        if (c1Count > n1) {
          return c2Count / n2;
        }
      } else {
        i++;
      }
    }
    // 计算，从c1Head开始,每c1N个c1中，会出现c2N个c2
    // n1个c1中包含多少个S2
    int cc2Count = c2Head + (n1 - c1Head) / c1N * c2N;
    int remainC1 = (n1 - c1Head) % c1N;
    if (remainC1 != 0) {
      int index = 0;
      int i = circleStart;
      if (circleStart == 0) {
        remainC1--;
      }
      while (true) {
        if (c1[i] == c2[index]) {
          index++;
          if (index == c2.length) {
            index = 0;
            cc2Count++;
          }
        }
        i++;
        if (i == c1.length) {
          if (remainC1 > 0) {
            remainC1--;
            i = 0;
          } else {
            break;
          }
        }
      }
    }
    return cc2Count / n2;
  }
}
