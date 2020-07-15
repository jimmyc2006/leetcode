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
        int i = 0, j = 0, c1Count = 1, c2Count = 0;
        int c1N = 0, c2N = 0, c1Head = 0, c2Head = 0; // 出现环之前匹配的几个c2
        int indexC1 = 0,lastMathc1Count = 1;
        Map<Integer, int[]> startMap = new HashMap<>();
        while (true) {
            if (c1[i] == c2[j]) {
                if (j == 0) {
                    int[] data = startMap.get(i);
                    if (data != null) {
                        if (c1Count == lastMathc1Count){
                            c1Head = data[0];
                            lastMathc1Count = 0;
                        } else {
                            c1Head = data[0] - 1;
                            lastMathc1Count = 1;
                        }
                        c2Head = data[1];
                        c1N = c1Count - data[0];
                        c2N = c2Count - data[1];
                        indexC1 = i;
                        break;
                    }
                    startMap.put(i, new int[]{c1Count, c2Count});
                }
                j++;
            }
            if (j == c2.length) {
                lastMathc1Count = c1Count;
                c2Count++;
                j = 0;
            }
            i++;
            if (i == c1.length) {
                c1Count++;
                if (c1Count > n1) {
                    return c2Count / n2;
                }
                i = 0;
            }
        }
        int remainC1 = n1 - c1Head;
        int totalC2Count = remainC1 / c1N * c2N + c2Head;
        if (remainC1 % c1N != 0) {
            int duoyu = remainC1 % c1N - lastMathc1Count;
            int k = 0;
            while (true) {
                if (c1[indexC1] == c2[k]) {
                    k++;
                    if (k == c2.length) {
                        totalC2Count++;
                        k = 0;
                    }
                }
                indexC1++;
                if (indexC1 == c1.length) {
                    if (duoyu > 0) {
                        duoyu--;
                        indexC1 = 0;
                    } else {
                        break;
                    }
                }
            }
        }
        return totalC2Count / n2;
    }
}
