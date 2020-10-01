package shuwei.leetcode.cn.two.zero.one;

public class Solution {
  /**
   * 试着使用数学方法:
   * 1. 只要m和n的二进制位的最高位不同，就说明产生了进位，结果就是0，因为进位的时候，只有最高位是1，其他位都是0
   * 2. 如果最高位一样,就看第二高位，只要有变动就停止，也就是只需要n和m进行运算
   * 因为没有负数
   * 7ms 打败39%
   * 6ms 99%
   */
  public int rangeBitwiseAnd(int m, int n) {
    int yihuo = m ^ n;
    // 异或如果大于m，说明有进位
    if(yihuo > m) {
      return 0;
    }
    int and = m & n;
    // 异或从第几位开始有1，就说明该停止了
    int pingbi = Integer.MAX_VALUE;
    int i = 0;
    while (yihuo > 0) {
      yihuo = yihuo >> 1;
      pingbi = pingbi << 1;
    }
    return and & pingbi;
  }

  /**
   *  先试试暴力,输入0，Ingteger.Max会超时
   *  变为long和增加0的判断以后，720ms，超过5%的人
   */
  public int rangeBitwiseAndB1(int m, int n) {
    int result = m;
    for(long i = (long)m + 1; i <= n; i++) {
      if (result == 0) {
        return 0;
      }
      result = result & (int)i;
    }
    return result;
  }
}
