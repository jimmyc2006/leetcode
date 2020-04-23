package shuwei.improve.sfdl.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* @author shuwei 
* @version 创建时间：2020年4月17日 下午12:30:00 
*/
// 第15章 动态规划 第一个例子，钢条切割问题,从底向上
public class Sample3 {
  private int[] p = new int[] {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
  private Map<Integer, Integer> res = new HashMap<>();
  // 从上到下，带中间结果的保存
  public int cutPod(int n) {
    int[] arr = new int[n];
    res.put(0, 0);
    int max = 0;
    for (int i = 1; i <= n; i++) {
      if (i < p.length) {
        max = p[i];
        arr[i - 1] = i;
      }
      for (int j = 1; j < p.length && j < i; j++) {
        int curVal =  p[j] + res.get(i - j);
        if (curVal > max) {
          max = curVal;
          arr[i - 1] = j;
        }
      }
      res.put(i, max);
    }
    System.out.println(n);
    System.out.println(Arrays.toString(arr));
    System.out.println(max);
    System.out.println("------------------");
    List<Integer> pos = new ArrayList<>();
    // 扫描输出结果
    int tmp = arr[n - 1];
    pos.add(tmp);
    n = n -tmp;
    while (n > 0) {
      tmp = arr[n - 1];
      pos.add(tmp);
      n = n - tmp;
    }
    System.out.println(pos);
    System.out.println("==================");
    return max;
  }
}
