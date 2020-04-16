package shuwei.leetcode.cn.matrix01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shuwei
 * @version 创建时间：2020年4月15日 上午9:02:22 解题思路: 创建一个同样大小的二维数组，先将距离为0和1的标志出来，四周没有0的数据不处理，但是下标记录在一个链表里
 *          后面不断的去遍历这个未标记的链表里面的数据，如果四面有值，它的值就是那个值加1，并从链表中移除，否则等待下轮处理，直到这个链表被清空
 *          这个类的解题方法效率比较低，应该是深度优先的一个递归的方法
 */
public class Solution2 {
  private int times = 0;
  public static void main(String[] args) {
    int[][] data = new int[][] {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
      {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
      {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
      {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
      {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
    Solution2 s = new Solution2();
    int[][] result = s.updateMatrix(data);
    for (int i = 0; i < result.length; i++) {
      System.out.println(Arrays.toString(result[i]));
    }
    System.out.println(s.times);
  }


  private final String splitter = ":";

  public int[][] updateMatrix(int[][] matrix) {
    int[][] result = new int[matrix.length][];
    List<String> needs = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      // 初始化结果数组
      result[i] = new int[matrix[i].length];
      Arrays.fill(result[i], -1);
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          result[i][j] = 0;
        } else {
          if ((i - 1 >= 0 && matrix[i - 1][j] == 0)
              || (i + 1 < matrix.length && matrix[i + 1][j] == 0)
              || (j - 1 >= 0 && matrix[i][j - 1] == 0)
              || (j + 1 < matrix[i].length && matrix[i][j + 1] == 0)) {
            result[i][j] = 1;
            needs.add(i + splitter + j);
          }
        }
      }
    }
    for (String ele : needs) {
      int x = Integer.parseInt(ele.split(splitter)[0]);
      int y = Integer.parseInt(ele.split(splitter)[1]);
      nextStep(result, x, y, 1);
    }
    return result;
  }

  public void nextStep(int[][] result, int i, int j, int deep) {
    times++;
    result[i][j] = deep++;
    if (i - 1 >= 0 && (result[i - 1][j] == -1 || result[i - 1][j] > deep)) {
      nextStep(result, i - 1, j, deep);
    }
    if (i + 1 < result.length && (result[i + 1][j] == -1 || result[i + 1][j] > deep)) {
      nextStep(result, i + 1, j, deep);
    }
    if (j - 1 >= 0 && (result[i][j - 1] == -1 || result[i][j - 1] > deep)) {
      nextStep(result, i, j - 1, deep);
    }
    if (j + 1 < result[i].length && (result[i][j + 1] == -1 || result[i][j + 1] > deep)) {
      nextStep(result, i, j + 1, deep);
    }
  }
}
