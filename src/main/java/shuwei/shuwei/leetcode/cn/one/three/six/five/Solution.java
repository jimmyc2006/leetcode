package shuwei.shuwei.leetcode.cn.one.three.six.five;

public class Solution {

  /**
   * 使用一个数组从0到100表示出现过的数
   * 倒序遍历这个数组，就能计算出每个数前面有几个数
   * 顺序遍历原数组，找得到每个元素对应的值，就能得出最终结果
   * @param nums
   * @return
   */
  public int[] smallerNumbersThanCurrent(int[] nums) {
    int[] times = new int[101];
    for(int ele : nums) {
      times[ele]++;
    }
    int smaller = 0;
    for (int i = 0; i <= 100; i++) {
      if (times[i] > 0) {
        int tmp = times[i];
        times[i] = smaller;
        smaller += tmp;
        if (smaller == nums.length) {
          break;
        }
      }
    }
    int[] ans = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      ans[i] = times[nums[i]];
    }
    return ans;
  }

}
