package shuwei.leetcode.cn.three.three.zero;

public class Solution {
  /**
   * 从1开始计数，1，2，当到3的时候，也就是2 * 2的时候，可以跳过，直接到4，因为1和2可以组成3
   * 从4开始5，6，7都可以用前面的数组成，用就是可以直接过度到4 * 2=8，用这个公式计算，下一个必须要的数是16
   * 如果原本的数组里面没有数据，用上面这个算法应该可以求出解，看一下有数据的情况
   * 无论怎样，1和2都是必须的，除非n<2
   * 那么假设原来的数组里有3，数值会变成1，2，3，那么4，5，6，可以直接跳过了，直接到7了，然后继续计算,8,9,10,11,12,13,也可以跳过，直接到14了
   * 这里缺少一个计算公式，就是出现3的时候，下一步应该跳到几，其实就是跳到了3和前面数值的总和的下一个，如果没有遇到阻拦，那么就继续是翻倍的跳
   * 还有就是存在重复数值的情况，如果出现2个1，那么2其实可以跳过的，到3后还是需要一个1或者2，那么优先选大的2，那么2以后就是5了，因为前面的总和已经到4
   * 如果遇到3个1的时候，那么下一个就是4，再下一个就是8
   * 综合一下，应该是从1开始，预期下一个是1的2倍，如果小于这个数，则将这个数跟1相加，例如1，1的情况，那么当前是2，到3的时候，直接补充3，那么下一个补充6，再下一个12
   * 如果下一个数比当前所有数的和小，就取这个数加进总数，再看下一个，是否是大于当前数的总数，如果是，就加入总数+1，依此类推
   *
   * @param nums
   * @param n
   * @return
   */
  public int minPatches(int[] nums, int n) {
    int ans = 0;
    long sum = 1;
    if (nums.length < 1 || nums[0] != 1) {
      ans++;
    }
    if (nums.length < 1) {
      nums = new int[]{n + 1};
    }
    for (int i = ans > 0 ? 0 : 1; i < nums.length && sum < n; i++) {
      if (sum >= n) {
        return ans;
      }
      while (sum + 1 < nums[i] && sum < n) {
        sum += sum  + 1;
        ans++;
      }
      sum += nums[i];
    }
    while(sum + 1 < n) {
      sum += sum  + 1;
      ans++;
    }
    return ans;
  }
}
