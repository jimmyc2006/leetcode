package shuwei.leetcode.cn.one.four.two.three;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int maxScore(int[] cardPoints, int k) {
    int length = cardPoints.length;
    int remain = length - k;
    int min = Integer.MAX_VALUE;
    int curr = 0;
    int start = 0;
    int totalSum = 0;
    for (int i = 0; i < length; i++) {
      totalSum += cardPoints[i];
      if(i < remain) {
        curr += cardPoints[i];
      } else {
        min = Math.min(min, curr);
        curr -= cardPoints[start];
        start++;
        curr += cardPoints[i];
      }
    }
    return totalSum - Math.min(min, curr);
  }
  /**
   * 这个dp算法超时
   * 优化，如果k比cardPoints的一半大，那么可以转化为求剩下的最小值
   * 也就是求length - k个连续最小值
   * @param cardPoints
   * @param k
   * @return
   */
  public int maxScore0(int[] cardPoints, int k) {
    System.out.println("-------");
    values = new HashMap<>();
    // 从start到end时候的最大值
    return cal(cardPoints, k, 0, cardPoints.length - 1);
  }

  Map<String, Integer> values;

  private int cal(int[] cards, int k, int start, int end) {
    String key = start + "-" + end + "-" + k;
    if (values.get(key) != null) {
      return values.get(key);
    }
    if (k == 0) {
      return 0;
    }
    if (start == end) {
      return cards[start];
    }
    System.out.println(start + ":" + end);
    int left = cal(cards, k - 1, start + 1, end) + cards[start];
    int right = cal(cards, k - 1, start, end - 1) + cards[end];
    int val = Math.max(left, right);
    values.put(key, val);
    return val;
  }
}
