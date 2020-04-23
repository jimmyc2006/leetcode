package shuwei.improve.sfdl.dp;

import java.util.HashMap;
import java.util.Map;

/** 
* @author shuwei 
* @version 创建时间：2020年4月17日 下午12:30:00 
*/
// 第15章 动态规划 第一个例子，钢条切割问题,带记忆的从顶到底
public class Sample2 {
  private int[] p = new int[] {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
  private Map<Integer, Integer> res = new HashMap<>();
  // 从上到下，带中间结果的保存
  public int cutPod(int n) {
    Integer tmpRes = res.get(n);
    if (tmpRes != null) {
      return tmpRes;
    }
    if (n ==0) {
      return 0;
    }
    int max = 0;
    if (n < p.length) {
      max = p[n];
    }
    for (int i = 1; i < n && i < p.length; i++) {
      max = Math.max(max, p[i] + cutPod(n - i));
    }
    res.put(n, max);
    return max;
  }
}
