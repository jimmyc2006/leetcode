package shuwei.leetcode.cn.five.six.nine.zero;

import java.util.Arrays;

public class Solution {
  // 这个有点类似背包问题s
  public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
    int ans = 0;
    int diff = Integer.MAX_VALUE;
    Arrays.sort(toppingCosts);
    for (int baseCost : baseCosts) {
      int res = baseCost + find(0, toppingCosts, target - baseCost);
      int tmpDif = Math.abs(target - res);
      if (tmpDif < diff) {
        ans = res;
        diff = tmpDif;
      } else if (tmpDif == diff) {
        ans = Math.min(res, ans);
      }
    }
    return ans;
  }

  private int find(int startIndex, int[] tops, int target) {
    if (target < 0) {
      return 0;
    }
    if (startIndex == tops.length) {
      return 0;
    }
    int res = 0;
    int diff = target;
    for (int i = 0; i <= 2; i++) {
      int tmpDiff;
      int tmpRes;
      if (i * tops[startIndex] < target) {
        int next = find(startIndex + 1, tops, target - i * tops[startIndex]);
        tmpRes = next + i * tops[startIndex];
      } else {
        tmpRes = i * tops[startIndex];
      }
      tmpDiff = Math.abs(target - tmpRes);
      if (tmpDiff < diff) {
        diff = tmpDiff;
        res = tmpRes;
      } else if (tmpDiff == diff){
        res = Math.min(tmpRes, res);
      }
    }
    return res;
  }
}
