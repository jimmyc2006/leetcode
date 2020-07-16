package shuwei.leetcode.cn.one.two.four.eight;

public class Solution {
  public int numberOfSubarrays(int[] nums, int k) {
    // 先把奇数取出来
    int[] jishu = new int[nums.length];
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
      if(nums[i] % 2 == 1) {
        jishu[index++] = i;
      }
    }
    int ans = 0;
    //  计算
    int start = -1, startIndex = 0;
    for (int i = 0, count = 0; i < jishu.length; i++) {
      count++;
      if (count == k) {
        int end = jishu[i];
        int step = jishu[startIndex] - start;
        ans += step;
        while((jishu[i + 1] == 0 && end < nums.length) ||
          ++end < jishu[i + 1]) {

        }
      }
    }
    return ans;
  }
}
