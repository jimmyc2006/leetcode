package shuwei.leetcode.cn.bs1;

public class Solution {
  public double average(int[] salary) {
    if (salary == null | salary.length < 1) {
      return 0;
    }
    int min = salary[0];
    int max = salary[0];
    int sum = salary[0];
    for (int i = 1; i < salary.length; i++) {
      sum += salary[i];
      min = Math.min(min, salary[i]);
      max = Math.max(max, salary[i]);
    }
    return (sum - min - max) / (double)(salary.length - 2);
  }
}
