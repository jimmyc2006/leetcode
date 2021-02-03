package shuwei.leetcode.cn.four.eight.zero;

import java.util.Arrays;

public class Solution {
  public double[] medianSlidingWindow(int[] nums, int k) {
    int length = nums.length;
    this.k = k;
    isOdd = (k & 1) == 1;
    double[] ans = new double[length - k + 1];
    int ansIndex = 0;
    int[] arr = Arrays.copyOfRange(nums,0, k);
    Arrays.sort(arr);
    int left = 0, right = k;  // 不包含k
    ans[ansIndex++] = cal(arr);
    while (right < length) {
      this.removeAndAdd(arr, nums[left++], nums[right++]);
      ans[ansIndex++] = cal(arr);
    }
    return ans;
  }

  private int k;
  private boolean isOdd = false;

  private double cal(int[] arr) {
    if (isOdd) {
      return arr[k / 2];
    } else {
      return ((double) arr[k / 2 - 1] + arr[k / 2]) / 2;
    }
  }

  private void removeAndAdd(int[] arr, int remove, int add) {
    if (remove == add) {
      return;
    }
    int removeIndex = Arrays.binarySearch(arr, remove);
    if (remove > add) {
      if (removeIndex == 0) {
        arr[0] = add;
        return;
      }
      int addIndex = find(arr, 0, removeIndex, add);
      addIndex = arr[addIndex] >= add ? addIndex : addIndex + 1;
      // 将右边所有值右移一位
      for (int i = removeIndex; i > addIndex; i--) {
        arr[i] = arr[i - 1];
      }
      arr[addIndex] = add;
    } else if (remove < add) {
      if (removeIndex == k - 1) {
        arr[removeIndex] = add;
        return;
      }
      int addIndex = find(arr, removeIndex + 1, k, add);
      addIndex = arr[addIndex] <= add ? addIndex : addIndex - 1;
      for (int i = removeIndex; i < addIndex; i++) {
        arr[i] = arr[i + 1];
      }
      arr[addIndex] = add;
    }
  }

  private int find(int[] arr, int start, int end, int data) {
    if (start + 1 == end) {
      return start;
    }
    // isBigger当前位置是否大于要找的值
    int mid = (start + end) / 2;
    if (arr[mid] == data) {
      return mid;
    } else if (arr[mid] < data) {
      return find(arr, mid, end, data);
    } else {
      return find(arr, start, mid, data);
    }
  }
}
