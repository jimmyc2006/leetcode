package shuwei.leetcode.cn.three.one;

public class Solution1110 {
  /**
   * 从后往前找，记录当前最大值的索引，如果发现比它小的值，交换，然后返回
   * 如果找到0还没有找到，那么就将该数组前后交换位置，然后返回
   * 如果是15432变换后为21345
   * 如果是35421变换后为41235,而不是45321
   * @param nums
   */
  public void nextPermutation(int[] nums) {
    if (nums.length < 2) {
      return;
    }
    int length = nums.length;
    for (int i = length - 2; i >= 0; i--) {
      int biggerIndex = this.findBigger(nums, nums[i], i);
      if (biggerIndex != -1) {
        swap(nums, i, biggerIndex);
        swapRange(nums, i + 1, length - 1);
        return;
      }
    }
    swapRange(nums, 0, length - 1);
  }

  private void swapRange(int[] nums, int start, int end) {
    for (;start < end; start++, end--) {
      swap(nums, start, end);
    }
  }
  private void swap(int[] nums, int srcIndex, int dstindex) {
    int tmp = nums[srcIndex];
    nums[srcIndex] = nums[dstindex];
    nums[dstindex] = tmp;
  }

  // 从右往左找到第一个比它小的数
  private int findBigger(int[] nums, int key, int start) {
    if (key > nums[start]) {
      return -1;
    }
    for (int i = nums.length - 1; i >= start; i--) {
      if (nums[i] > key) {
        return i;
      }
    }
    return -1;
  }
}
