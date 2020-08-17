//package shuwei.leetcode.cn.five.four.six;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Solution {
//  /**
//   * 思路：动态规划，每次往后多加一个数字，如果这个数字跟前面的某一个数字相等，就多一种算法 最后比较算法最大值，每次只处理新加的数值 f[i][j]表示从i到j的最大值
//   */
//  public int removeBoxes(int[] boxes) {
//    int length = boxes.length;
//    int[] dp = new int[length];
//    dp[0] = 1;
//    for (int i = 1; i < length; i++) {
//      int j = i;
//      while (i + 1 < length && boxes[i] == boxes[i + 1]) {
//        i++;
//      }
//      {
//        List<Integer> sames = find(boxes, i);
//        // 最后一个是自己
//        for (int k = 0; k < sames.size() - 1; k++) {
//        }
//      }
//    }
//    return dp[length - 1][length - 1];
//  }
//
//  Map<Integer, List<Integer>> cache = new HashMap<>();
//
//  private List<Integer> find(int[] boxes, int end) {
//    List<Integer> vals = cache.get(boxes[end]);
//    if (vals == null) {
//      vals = new ArrayList<>();
//      cache.put(boxes[end], vals);
//    }
//    vals.add(end);
//    return vals;
//  }
//}
