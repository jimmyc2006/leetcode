package shuwei.leetcode.cn.eight.five;

public class Solution {
  /**
   * 思路1：
   * 先将每一行数据从后向前遍历，计算出连续的1的个数
   * 然后再将整个二维数组从前往后，从上往下遍历
   *
   * @param matrix
   * @return
   */
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length < 1 || matrix[0].length < 1) {
      return 0;
    }
    int[][] data = new int[matrix.length][matrix[0].length];
    for(int i = 0; i < matrix.length; i++){
      int count = 1;
      for (int j = matrix[i].length - 1; j >= 0; j--) {
        if (matrix[i][j] == '1') {
          data[i][j] = count;
          count++;
        } else {
          count = 1;
        }
      }
    }
    int ans = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (data[i][j] > 0) {
          // 如果上一行已经处理过，就直接跳过
          if (i - 1 >= 0 && data[i - 1][j] >= data[i][j]) {
            continue;
          }
          ans = Math.max(ans, data[i][j]);
          int k = i;
          int high = 1, width = data[i][j];
          while (k + 1 < matrix.length && data[k + 1][j] > 0) {
            high++;
            width = Math.min(data[k + 1][j], width);
            if (i - 1 >= 0 && width == 1 && data[i - 1][j] > 0) {
              break;
            }
            ans = Math.max(ans, high * width);
            k++;
          }
        }
      }
    }
    return ans;
  }
}
