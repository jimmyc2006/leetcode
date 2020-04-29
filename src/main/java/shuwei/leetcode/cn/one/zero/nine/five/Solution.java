package shuwei.leetcode.cn.one.zero.nine.five;

public class Solution {

  public int findInMountainArray(int target, MountainArray mountainArr) {
    int length = mountainArr.length();
    int start = 0;
    int startVal = mountainArr.get(start);
    int end = length - 1;
    int endVal = mountainArr.get(end);
    if (target < startVal && target < endVal) {
      return -1;
    }
    // 在右边
    if (target < startVal) {
      return rightFind(target, mountainArr, start, end);
    }
    // 在左边
    if (target < endVal) {
      return leftFind(target, mountainArr, start, end);
    }
    // 可能在左边，也可能在右边
    int leftFind = leftFind(target, mountainArr, start, end);
    if (leftFind >= 0) {
      return leftFind;
    }
    return rightFind(target, mountainArr, start, end);
  }

  private int leftFind(int target, MountainArray mountainArr, int start, int end) {
    int startVal = mountainArr.get(start);
    int endVal = mountainArr.get(end);
    while (true) {
      int middle = (end - start) / 2;
      int middleValue = mountainArr.get(start + middle);
      int middleRightValue = mountainArr.get(start + middle + 1);
      if (middleRightValue < middleValue) {
        // 右边下山
        end = end - middle;
        endVal = mountainArr.get(end);
      } else {
        if (target == startVal) {
          return start;
        }
        if (target == endVal && endVal > mountainArr.get(end - 1)) {
          return end;
        }
        if (target == middleValue) {
          return start + middle;
        }
        // 左边上山
        if (target < middleValue) {
          end = end - middle;
          endVal = mountainArr.get(end);
        } else {
          start = start + middle;
          startVal = mountainArr.get(start);
        }
      }
      if (middle == 0) {
        return -1;
      }
    }
  }

  private int rightFind(int target, MountainArray mountainArr, int start, int end) {
    int startVal = mountainArr.get(start);
    int endVal = mountainArr.get(end);
    while (true) {
      int middle = (end - start) / 2;
      int middleValue = mountainArr.get(start + middle);
      int middleRightValue = mountainArr.get(start + middle + 1);
      if (middleRightValue < middleValue) {
        // 右边下山
        if (target == endVal) {
          return end;
        }
        if (target == startVal && startVal < mountainArr.get(start - 1)) {
          return start;
        }
        if (target == middleValue) {
          return start + middle;
        }
        if (target > middleRightValue) {
          end = end - middle;
          endVal = mountainArr.get(end);
        } else {
          start = start + middle;
          startVal = mountainArr.get(start);
        }
      } else {
        // 左边上山
        start = start + middle;
        startVal = mountainArr.get(start);
      }
      if (middle == 0) {
        return -1;
      }
    }
  }
}
