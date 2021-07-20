package shuwei.leetcode.cn.five.seven.zero.three;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
  /**
   * 最后一步应该是将1个学生给某个班级，然后计算最大平均值
   * 子问题是，extraStudents为extraStudents - 1的时候，给这些班级的最大平均值，但是下一个最大平均值，跟上一个没有必然关系？
   * 应该挑选不满的班级中，分母最小的,也就是将它们放在一个优先队列中
   * @param classes
   * @param extraStudents
   * @return
   */
  public double maxAverageRatio(int[][] classes, int extraStudents) {
    PriorityQueue<int[]> data = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        double d1 = (double)o1[0]/o1[1];
        double d2 = (double)(o1[0] + 1) / (o1[1] + 1);
        double d3 = (double)o2[0]/o2[1];
        double d4 = (double)(o2[0] + 1) / (o2[1] + 1);
        if (d2 - d1 > d4 - d3) {
          return -1;
        } else {
          return 1;
        }
      }
    });
    for (int[] aClass : classes) {
      data.add(aClass);
    }
    while (extraStudents > 0) {
      int[] lit = data.poll();
      lit[0]++;
      lit[1]++;
      extraStudents--;
      data.add(lit);
    }
    double sum = 0;
    for (int[] ele : data) {
      sum += (double)ele[0] / ele[1];
    }
    return sum / classes.length;
  }
}
