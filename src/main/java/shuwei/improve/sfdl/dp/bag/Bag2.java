package shuwei.improve.sfdl.dp.bag;

public class Bag2 {
  // 为了更具有普适性，增加一个W数组
  private int[] W = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  private int[] V = new int[] {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
  
  public int maxValue2(int maxWeight) {
    int[] data = new int[maxWeight + 1];
    for (int i = 1; i < W.length ; i++) {
      for (int j = maxWeight; j > 0; j--) {
        for (int times = 0; j >= times * W[i]; times++) {
          int currMax = Math.max(data[j], data[j - times * W[i]] + times * V[i]);
          if (currMax > data[j]) {
            data[j] = currMax;
          }
        }
      }
    }
    return data[data.length - 1];
  }
  
  // 完全背包问题
  // f[i][j] = max(f[i -1 ][j], f[i][j - W[i]] + V[j], f[i][j - 2 * W[i]] + 2 * V[j],...)
  public int maxValue1(int maxWeight) {
    // 从底向上，二维数组保存
    int[][] data = new int[W.length][maxWeight + 1];
    for (int i = 1; i < W.length ; i++) {
      for (int j = 1; j <= maxWeight; j++) {
        for (int times = 0; j >= times * W[i]; times++) {
          int currMax = Math.max(data[i - 1][j], data[i][j - times * W[i]] + times * V[i]);
          if (currMax > data[i][j]) {
            data[i][j] = currMax;
          }
        }
      }
    }
    return data[W.length - 1][maxWeight];
  }
}
