package shuwei.leetcode.cn.mst.five.one;

public class Solution1108 {
  public int reversePairs(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }
    ans = 0;
    mergeSort(nums, 0, nums.length - 1);
    return ans;
  }

  int ans;
  // 包含start和end, 使用内部返回新数组的方法-2, 4, 3, 5, 1
  private int[] mergeSort(int[] nums, int start, int end) {
    if (start == end) {
      return new int[]{nums[start]};
    }
    int mid = start + (end - start) / 2;
    int[] left = mergeSort(nums, start, mid);
    int[] right = mergeSort(nums, mid + 1, end);
    int rightLength = right.length;
    int[] result = new int[left.length + rightLength];
    int i = 0, j = 0, index = 0;
    while (i < left.length || j < rightLength) {
      if (i == left.length) {
        result[index++] = right[j++];
      } else if(j == rightLength || left[i] <= right[j]) {
        result[index++] = left[i++];
        ans += j;
      } else {
        result[index++] = right[j++];
      }
    }
    return result;
  }
}
