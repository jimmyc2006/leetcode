package shuwei.leetcode.cn.four;

public class Solution {
  // 优化为递归调用
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1 == null || nums1.length < 1) {
      return median(nums2);
    } else if (nums2 == null || nums2.length < 1) {
      return median(nums1);
    }
    int total = nums1.length + nums2.length;
    int needLeft;
    boolean isOdd;
    if (total % 2 == 1) {
      isOdd = true;
      needLeft = total / 2;
    } else {
      isOdd = false;
      needLeft = total / 2 - 1;
    }
    return medianSorted(nums1, nums2, 0, nums1.length, 0, nums2.length, 0, needLeft, total);
  }

  private double medianSorted(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int left, int needLeft, int total) {
    if (left < needLeft) {
      // 谁小谁就右移
      if (nums1[start1] < nums2[start2]) {
        int mid = (end1 - start1) / 2;
        // 如果已经到了尾部，直接从nums2里面获取结果
        if (mid == 0) {
          return median(nums2, start2 + (needLeft - left - 1), total);
        }
        // 右移
        return medianSorted(nums1, nums2, start1 + mid, end1, start2, end2, left + mid, needLeft, total);
      } else {
        int mid = (end2 - start2) / 2;
        if (mid == 0) {
          return median(nums1, start1 + (needLeft - left - 1), total);
        }
        return medianSorted(nums1, nums2, start1, end1, start2 + mid, end2, left + mid, needLeft, total);
      }
    } else if (left > needLeft) {
      // 谁大谁左移
      if (nums1[start1] > nums2[start2]) {
        int mid = (start1 + 1) / 2;
        if (mid == 0) {
          // 头部
          return median(nums2, start2 + needLeft - left, total);
        }
        // 左移，注意需要左移的数组，因为start已经超过中位数范围，直接可以作为end,这个一定要想清楚，否则可能有问题
        return medianSorted(nums1, nums2, start1 - mid, start1, start2, end2, left - mid, needLeft, total);
      } else {
        int mid = (start2 + 1) / 2;
        if (mid == 0) {
          return median(nums1, start1 + needLeft - left, total);
        }
        return medianSorted(nums1, nums2, start1, end1, start2 - mid, start2, left - mid, needLeft, total);
      }
    } else {
      // 可能出现答案,先检查nums1[start] 是否是答案位置
      if (nums1[start1] < nums2[start2]) {
        if (start2 - 1 >= 0 && nums1[start1] < nums2[start2 - 1]) {
          // nums2左移
          return medianSorted(nums1, nums2, start1, end1, start2 - (start2 + 1) / 2, start2, left - (start2 + 1) / 2, needLeft, total);
        }
        if (total % 2 == 1) {
          return nums1[start1];
        } else {
          if (start1 + 1 < nums1.length && nums1[start1 + 1] < nums2[start2]) {
            return ((nums1[start1] + nums1[start1 + 1])) / 2.0;
          } else {
            return (nums1[start1] + nums2[start2]) / 2.0;
          }
        }
      } else {
        // nums1左移
        if (start1 - 1 >= 0 && nums2[start2] < nums1[start1 - 1]) {
          return medianSorted(nums1, nums2, start1 - (start1 + 1) / 2, start1, start2, end2, left - (start1 + 1) / 2, needLeft, total);
        }
        if (total % 2 == 1) {
          return nums2[start2];
        } else {
          if (start2 + 1 < nums2.length && nums2[start2 + 1] < nums1[start1]) {
            return (nums2[start2] + nums2[start2 + 1]) / 2.0;
          } else {
            return (nums1[start1] + nums2[start2]) / 2.0;
          }
        }
      }
    }
  }

  // 返回数组的中位数
  private double median(int[] arr) {
    int length = arr.length;
    if (length % 2 == 1) {
      return arr[length / 2];
    } else {
      int s = arr.length / 2 - 1;
      return (arr[s] + arr[s + 1]) / 2.0;
    }
  }


  private double median(int[] arr, int start, int totalLength) {
    if (totalLength % 2 == 1) {
      return arr[start];
    } else {
      return (arr[start] + arr[start + 1]) / 2.0;
    }
  }

  // 2ms beat 100
//  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//    if (nums1 == null || nums1.length < 1) {
//      return median(nums2);
//    } else if (nums2 == null || nums2.length < 1) {
//      return median(nums1);
//    }
//    int left = 0;
//    int total = nums1.length + nums2.length;
//    int needLeft = total % 2 == 0 ? total / 2 - 1 : total / 2;
//
//    int start1 = 0, end1 = nums1.length;
//    int start2 = 0, end2 = nums2.length;
//
//    while (true) {
//      if (left < needLeft) {
//        // 右移
//        if (nums1[start1] <= nums2[start2]) {
//          int middle = (end1 - start1) / 2;
//          if (middle == 0) {
//            // 数组1已经到尾部
//            start2 = start2 + (needLeft - left - 1);
//            return median(nums2, start2, total);
//          }
//          left = left + middle;
//          start1 = start1 + middle;
//        } else {
//          int middle = (end2 - start2) / 2;
//          // 数组2已经到了尾部
//          if (middle == 0) {
//            start1 = start1 + (needLeft - left - 1);
//            return median(nums1, start1, total);
//          }
//          left = left + middle;
//          start2 = start2 + middle;
//        }
//      } else if (left > needLeft) {
//        // 左移
//        if (nums1[start1] >= nums2[start2]) {
//          int middle = (start1 - 0 + 1) / 2;
//          // 已经到了头部
//          if (middle == 0) {
//            start2 = start2 - (left - needLeft);
//            if (total % 2 == 1) {
//              return nums2[start2];
//            } else {
//              return (nums2[start2] + nums2[start2 + 1]) / 2.0;
//            }
//          }
//          left -= middle;
//          end1 = start1;
//          start1 = start1 - middle;
//        } else {
//          int middle = (start2 - 0 + 1) / 2;
//          if (middle == 0) {
//            // 已经到了头部
//            start1 = start1 - (left - needLeft);
//            if (total % 2 == 1) {
//              return nums1[start1];
//            } else {
//              return (nums1[start1] + nums1[start1 + 1]) / 2.0;
//            }
//          }
//          left -= middle;
//          end2 = start2;
//          start2 = start2 - middle;
//        }
//      } else {
//        if (nums1[start1] > nums2[start2]) {
//          if (start1 - 1 >= 0 && nums2[start2] < nums1[start1 - 1]) {
//            // 2的太小了，将1往左移动
//            start1 = start1 - 1;
//            left--;
//            continue;
//          }
//          // 出现答案
//          if (total % 2 == 1) {
//            return nums2[start2];
//          } else {
//            if (start2 + 1 < nums2.length && nums2[start2 + 1] < nums1[start1]) {
//              return (nums2[start2] + nums2[start2 + 1]) / 2.0;
//            } else {
//              return (nums2[start2] + nums1[start1]) / 2.0;
//            }
//          }
//        } else {
//          if (start2 - 1 >= 0 && nums1[start1] < nums2[start2 - 1]) {
//            // 2的太小了，将1往左移动
//            start2 = start2 - 1;
//            left--;
//            continue;
//          }
//          // 出现答案
//          if (total % 2 == 1) {
//            return nums1[start1];
//          } else {
//            if (start1 + 1 < nums1.length && nums1[start1 + 1] < nums2[start2]) {
//              return (nums1[start1] + nums1[start1 + 1]) / 2.0;
//            } else {
//              return (nums1[start1] + nums2[start2]) / 2.0;
//            }
//          }
//        }
//      }
//    }
//  }

}
