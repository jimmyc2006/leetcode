package shuwei.leetcode.cn.six.zero;

public class Solution {

  /**
   * 从右往左可以计算这个值 例如k是5的时候，从右往左1*2*3=6比5大，1*2*2=4比5小，所以第3位直接挑过1个数2个数后，第一个数就是结果
   * 第一位前进一位，那么数值会增大1*2*3..(n-1) 第二位前进一位，那么数值会增大1*2*3..(n-2)
   * 这个算法可以打败100%
   */
  public String getPermutation(int n, int k) {
    status = new boolean[n + 1];
    values = new int[n + 1];
    times = 0;
    int sum = 1;
    for (int i = 1; i <= n; i++) {
      sum *= i;
      values[i] = sum;
    }
    // values为某一位如果前进一个数值，times相应的增加多少值
    StringBuilder ans = new StringBuilder();
    find(n, k, 1, ans);
    return ans.toString();
  }

  private boolean[] status;
  private int[] values;
  private int times;

  private boolean find(int n, int k, int level, StringBuilder sb) {
    int jump = 1;
    while (n != level && values[n - level] * jump < k - times) {
      jump++;
    }
    jump--;
    times = times + values[n - level] * jump;
    for (int i = 1; i <= n; i++) {
      if (!status[i]) {
        if (jump > 0) {
          jump--;
          continue;
        }
        status[i] = true;
        sb.append(i);
        if (level == n) {
          times++;
          if (times == k) {
            return true;
          }
        } else {
          if (find(n, k, level + 1, sb)) {
            return true;
          }
        }
        sb.deleteCharAt(sb.length() - 1);
        status[i] = false;
      }
    }
    return false;
  }
}
