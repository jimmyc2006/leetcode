package shuwei.leetcode.cn.three.five.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution {
  /**
   * 改进为从后往前遍历，从大往小
   * @param envelopes
   * @return
   */
  TreeMap<Integer, List<int[]>> data;
  public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      }
      return o1[0] - o2[0];
    });
    data = new TreeMap<>();
    boolean find;
    for (int i = envelopes.length - 1; i >= 0; i--) {
      find = false;
      for (Integer key : data.descendingKeySet()) {
        List<int[]> vals = data.get(key);
        for (int[] val : vals) {
          if (val[0] > envelopes[i][0] && val[1] > envelopes[i][1]) {
            List<int[]> ints = data.get(key + 1);
            if (ints == null) {
              ints = new ArrayList<>();
              ints.add(envelopes[i]);
              data.put(key + 1, ints);
            } else {
              ints.add(envelopes[i]);
            }
            find = true;
            break;
          }
        }
        if (find) {
          break;
        }
      }
      if (!find) {
        List<int[]> ints = data.get(1);
        if (ints == null) {
          ints = new ArrayList<>();
          data.put(1, ints);
        }
        ints.add(envelopes[i]);
      }
    }
    return data.lastKey();
  }

  /**
   * 可以ac，但是速度比较慢
   * @param envelopes
   * @return
   */
  public int maxEnvelopes1(int[][] envelopes) {
    Arrays.sort(envelopes, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      }
      return o1[0] - o2[0];
    });
    length = envelopes.length;
    dp = new int[length + 1][length + 1];
    envs = envelopes;
    return deal(0, 1);
  }

  private int[][] envs;
  private int length;
  private int[][] dp;

  private int deal(int cal, int curr) {
    if (curr == length) {
      return 1;
    }
    if (dp[cal][curr] > 0) {
      return dp[cal][curr];
    }
    int res;
    if (envs[curr][0] > envs[cal][0] &&
            envs[curr][1] > envs[cal][1]) {
      res = Math.max(1 + deal(curr, curr + 1), deal(cal, curr + 1));
    } else {
      if (cal == 0) {
        res = Math.max(deal(curr, curr + 1), deal(cal, curr + 1));
        ;
      } else {
        res = deal(cal, curr + 1);
      }
    }
    dp[cal][curr] = res;
    return res;
  }
}
