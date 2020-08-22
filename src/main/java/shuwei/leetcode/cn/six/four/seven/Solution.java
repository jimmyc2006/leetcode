package shuwei.leetcode.cn.six.four.seven;

public class Solution {

  /**
   * 马拉车算法，它的思想是先给字符串中的每个字符左右各增加一个原来不存在的字符串
   * 再给两边各增加一个不同的符号，然后开始从第1个元素开始遍历
   * 记录一个最大值时候的r,还有这个r的中心点的索引center
   * 如果当前遍历的位置i，在center+r内，那么先找到已经遍历过的center左边和它对称的点:before=center-(i-center)=2center - i
   * 如果before的贡献数是x，则比较i+x和center+r的大小，如果i+x<center+r，那么直接i的贡献点数就是before
   * 如果i+x>=center+r，则i的贡献点数计算为center+r-i,然后在继续观察
   * 最后将所有字符贡献点数加起来，就是所求答案
   *
   * 原字符:abccbad转化
   * 01234567890123456
   * @#a#b#c#c#b#a#d#@
   * 从2开始,当前center为1，r=1
   * 2的位置是a,center+r=2，需要遍历2，先比较3和1，发现一样，然后比较4和0，结果不一样；则center更新为2，r更新为2
   * 3的位置是#,2+2=4正好是3+1,所以3初始值r=1需要继续观察,发现4和2不同，则center更新为3，r更新为1
   * 4的位置是b,3+1=4,所以需要观察4，由于5和3相同，6和2不同，则4的r是2；center跟为难为4，r更新为2
   * 5的位置是#，4+2=6,6不大于5+1，5从1开始,6和4不同，则center为5,r=1
   * 6的位置是c,5+1=6不大于6+1，所以6从1开始,7和5不同，所以center为6,r为2
   * 7的位置是#，6+2不大于7+1,所以7从1开始,8和6同,9和5同，10和4同，11和3同，12和2同，13和1同，14和0不同，所以center更新为7,r为7
   * 8的位置是c,7+7=14大于8+1,所以8找7对称的点为2*7-8=6,6的r为1，8+1<14所以8的r也为2
   * 9的位置是#，14>10,所以9找堆成5,5的r为1，9+1<14，所以9贡献1
   * 依此类推...
   * 最后合并结果是向下/2取整综合
   * 这其中,增加@#!是固定写法，最后取整也是固定写法，注意@#!必须互相不同
   * 
   */
  public int countSubstrings(String s) {
    char[] oldChars = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    sb.append("@#");
    char SPLITTER = '#';
    for (int i = 0; i < oldChars.length; i++) {
      sb.append(oldChars[i]);
      sb.append(SPLITTER);
    }
    sb.append("!");
    char[] newChars = sb.toString().toCharArray();
    int center = 1, r = 1;
    int[] result = new int[newChars.length];
    result[1] = 1;
    for (int i = 2; i < newChars.length - 1; i++) {
      int ri = 1;
      if (center + r > i + ri) {
        ri = result[center * 2 - i];
        if (i + ri < center + r) {
          result[i] = ri;
          continue;
        } else {
          ri = center + r - i;
        }
      }
      while (newChars[i + ri] ==  newChars[i - ri]) {
        ri++;
      }
      result[i] = ri;
      if (i + ri > center + r) {
        center = i;
        r = ri;
      }
    }
    int ans = 0;
    for (int i = 1; i < result.length - 1; i++) {
        ans += result[i] / 2;
    }
    return ans;
  }
}
