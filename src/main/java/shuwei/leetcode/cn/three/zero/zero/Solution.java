package shuwei.leetcode.cn.three.zero.zero;

public class Solution {
  /**
   * 题解的算法1的dp自己已写出，这个是题解的贪心+二分算法，这是个比较神奇的算法，需要好好体会这种算法
   * 或者多体会贪心算法，总是用后面的数替换第一个比它大的数，如果没有就添加
   * @param nums
   * @return
   */
  public int lengthOfLIS(int[] nums) {
    int[] d = new int[nums.length];
    d[0] = nums[0];
    int len = 1;
    for (int i = 1; i < nums.length; i++) {
      int index = bSearch(d, 0, len, nums[i]);
      if (index == len) {
        d[len] = nums[i];
        len++;
      } else {
        d[index] = nums[i];
      }
    }
    return len;
  }

  // 找到刚好比num大的数的索引,不包含end
  private int bSearch(int[] d, int start, int end, int num) {
    if (start == end) {
      return end;
    }
    int mid = (start + end) / 2;
    if (d[mid] < num) {
      return bSearch(d, mid + 1, end, num);
    } else if(d[mid] == num) {
      return mid;
    } else {
      return bSearch(d, start, mid, num);
    }
  }

  /**
   * 采用从后往前找的方式 矛盾点：每个点检查的时候，都需要检查它后面的所有大于它的元素当前的值，然后取最大值加1 这个查找的过程没想到怎么优化，如果将后面的按照数值排序，那么也需要扫描所有大于当前数值的所有值，找到它们对应的最大值,这个可能需要一个HashTree,但是貌似比如下面那个方法好
   * 如果将它们对应的值排序，那么也需要从大到小找到最先满足的值，这样可能需要维护一个HashTree
   * 通过剪枝优化后的，仍然不够快77%
   *
   */
  public int lengthOfLIS2(int[] nums) {
    int length = nums.length;
    int[] dp = new int[length];
    for (int i = length - 1; i >= 0; i--) {
      int max = 0;
      for (int j = i + 1; j < length; j++) {
        if (nums[j] > nums[i]) {
          max = Math.max(max, dp[j]);
        } else {
          // 如果比当前值还小的数值的积分已经比当前积分小了，不用再继续往后找了
          if (dp[j] <= max) {
            break;
          }
        }
      }
      dp[i] = 1 + max;
    }
    int ans = 0;
    for (int i : dp) {
      ans = Math.max(ans, i);
    }
    return ans;
  }

}
