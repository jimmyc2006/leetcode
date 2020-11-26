package shuwei.leetcode.cn.one.six.four;

public class Solution {
  /**
   * 此题看了题解，使用桶排序
   * @param nums
   * @return
   */
  public int maximumGap(int[] nums) {
    if (nums.length < 2) {
      return 0;
    }
    int max = 0;
    int min = Integer.MAX_VALUE;
    for (int ele : nums) {
      max = Math.max(ele, max);
      min = Math.min(min, ele);
    }
    if (max == min) {
      return 0;
    }
    int step = (max - min) / (nums.length - 1);
    if (step == 0) {
      step = 1;
    }
    int[][] bucketData = new int[(max - min) / step + 1][2];
    for (int ele : nums) {
      int bucketIndex = (ele - min) / step;
      if (bucketData[bucketIndex][0] == 0 || ele < bucketData[bucketIndex][0]) {
        bucketData[bucketIndex][0] = ele;
      }
      if (bucketData[bucketIndex][1] == 0 || bucketData[bucketIndex][1] < ele) {
        bucketData[bucketIndex][1] = ele;
      }
    }
    int ans = 0;
    int last = bucketData[0][1];
    for (int i = 1 ; i < bucketData.length; i++) {
      if (bucketData[i][0] > 0) {
        ans = Math.max(ans, bucketData[i][0] - last);
        last = bucketData[i][1];
      }
    }
    return ans;
  }
}
