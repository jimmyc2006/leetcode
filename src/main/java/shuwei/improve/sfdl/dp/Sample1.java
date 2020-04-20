package shuwei.improve.sfdl.dp;
/** 
* @author shuwei 
* @version 创建时间：2020年4月17日 下午12:30:00 
*/
// 第15章 动态规划 第一个例子，钢条切割问题
public class Sample1 {
  private int[] p = new int[] {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
  
  public int cutPod(int n) {
    if (n ==0) {
      return 0;
    }
    int max = 0;
    for (int i = 1; i <= n; i++) {
      max = Math.max(max, p[i] + cutPod(n - i));
    }
    return max;
  }
}
