package shuwei.improve.bag;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuwei
 * @version 创建时间：2020年4月24日 上午8:31:45 类说明
 */
// 有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]。
// 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
// 状态转移方程是： f[i][v]=max{f[i-1][v],f[i-1][v-c[i]]+w[i]}
public class Bag1 {

  public Map<Integer, int[]> init() {
    Map<Integer, int[]> data = new HashMap<>();
    data.put(1, new int[] {2, 3});
    data.put(2, new int[] {3, 4});
    data.put(3, new int[] {4, 5});
    data.put(4, new int[] {5, 8});
    data.put(5, new int[] {9, 10});
    return data;
  }

  private int[] W = new int[]{0, 2, ,3, 4, 5, 9};
  private int[] V = new int[]{0, 3, 4, 5, 8, 10};

  // 一围数组的解法
  public int bagArr(int maxSpace) {
    int[] dp = new int[maxSpace];
    for (int i = 0; i <= maxSpace; i++) {
      for (int j = maxSpace; j > 0; j--) {
        if (W[i] <= j) {
          dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
        } else {
          dp[j] = dp[j];
        }
      }
    }
    return dp[maxSpace];
  }

  public int bagPro(Map<Integer, int[]> data, int maxWeight) {
    int[][] result = new int[data.size() + 1][maxWeight + 1];
    for (int i = 1; i <= data.size(); i++) {
      for (int j = 1; j <= maxWeight; j++) {
        if (j - data.get(i)[0] >= 0) {
          result[i][j] =
              Math.max(result[i - 1][j], result[i - 1][j - data.get(i)[0]] + data.get(i)[1]);
        } else {
          result[i][j] = result[i - 1][j];
        }
      }
    }
    return result[data.size()][maxWeight];
  }

  // 递归实现方式
  public int bagProRecursion(Map<Integer, int[]> data, int maxKey, int maxWeight) {
    if (maxKey <= 0) {
      return 0;
    }
    if (maxWeight < data.get(1)[0]) {
      return 0;
    }
    int maxResult = 0;
    if (maxWeight - data.get(maxKey)[0] >= 0) {
      maxResult = Math.max(bagProRecursion(data, maxKey - 1, maxWeight),
          bagProRecursion(data, maxKey - 1, maxWeight - data.get(maxKey)[0]) + data.get(maxKey)[1]);
    } else {
      maxResult = bagProRecursion(data, maxKey - 1, maxWeight);
    }
    return maxResult;
  }
}
