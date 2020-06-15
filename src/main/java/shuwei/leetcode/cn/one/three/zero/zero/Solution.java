package shuwei.leetcode.cn.one.three.zero.zero;

import java.util.Arrays;

public class Solution {

  // 不排序
  public int findBestValue(int[] arr, int target) {
    int ans = 0;
    int minDiff = Integer.MAX_VALUE;
    int average = target / arr.length;
    int end = 0;
    for (int i = 0; i < arr.length; i++) {
      end = Math.max(end, arr[i]);
    }
    if (end <= average) {
      return end;
    }
    int start = average;
    while (start <= end) {
      int middle = (start + end) / 2;
      int sum = 0;
      for (int ele : arr) {
        if (ele <= middle) {
          sum += ele;
        } else {
          sum += middle;
        }
      }
      int thisDiff;
      if (sum < target) {
        thisDiff = target - sum;
        start = middle + 1;
      } else {
        thisDiff = sum - target;
        end = middle - 1;
      }
      if (thisDiff <= minDiff) {
        if (thisDiff == minDiff) {
          ans = Math.min(ans, middle);
        } else {
          ans = middle;
        }
        minDiff = thisDiff;
      }
    }
    return ans;
  }

  private int minDiff(int base, int start, int times, int target) {
    int sum1 = base + start * times;
    int diff1 = target - sum1;
    int sum2 = sum1 + times;
    int diff2 = sum2 - target;
    if (diff2 >= diff1) {
      return start;
    } else {
      return start + 1;
    }
  }

  // 这个思路更新了以后，还是3ms
  public int findBestValue2(int[] arr, int target) {
    Arrays.sort(arr);
    int sum = 0;
    int average = target / arr.length;
    if (arr[0] > average) {
      return this.minDiff(0, average, arr.length, target);
    }
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < average) {
        sum += arr[i];
      } else {
        // 遇到大于平均值的成员
        int ifSum = sum + arr[i] * (arr.length - i);
        if (target > ifSum) {
          sum += arr[i];
        } else {
          int ave = (target - sum) / (arr.length - i);
          return this.minDiff(sum, ave, arr.length - i, target);
        }
      }
    }
    return arr[arr.length - 1];
  }

  // 3ms 65%
  public int findBestValue1(int[] arr, int target) {
    Arrays.sort(arr);
    int aLength = arr.length;
    int average = target / aLength;
    int sum = arr[0];
    if (sum >= average) {
      int small = target - average * aLength;
      int big = (average + 1) * aLength - target;
      if (big > small) {
        return average;
      } else {
        return average + 1;
      }
    }
    int minDiff = target;
    int start = average;
    int end = arr[aLength - 1];
    int num = 0;
    for (int i = 1; i < aLength; i++) {
      if (arr[i] < start) {
        sum += arr[i];
      } else {
        // 遇到大于平均值的成员
        num = aLength - i;
        int ifSum = sum + arr[i] * num;
        if (target > ifSum) {
          start = arr[i];
          sum += arr[i];
        } else if (ifSum == target) {
          return arr[i];
        } else {
          end = arr[i];
          break;
        }
      }
    }
    // 从start开始
    int ans = 0;
    while (start <= end) {
      int test = (end + start) / 2;
      int ifSum = sum + test * num;
      int diff;
      if (target > ifSum) {
        diff = target - ifSum;
        if (minDiff > diff) {
          minDiff = diff;
          ans = start;
        }
        start = test + 1;
      } else if (target == ifSum) {
        return test;
      } else {
        diff = ifSum - target;
        if (minDiff > diff) {
          minDiff = diff;
          ans = test;
        }
        end = test - 1;
      }
    }
    return ans;
  }

}
