package shuwei.leetcode.cn.two.eight.seven;

public class Solution {
  // floyd 判圈算法
  public int findDuplicate(int[] nums) {
    if (nums == null ) {
      return 0;
    }
    if (nums.length < 3) {
      return nums[0];
    }
    int slow = nums[0], quick = nums[0];
    do {
      slow = nums[slow];
      quick = nums[quick];
      quick = nums[quick];
    } while (slow != quick);
    slow = nums[0];
    while(slow != quick) {
      slow = nums[slow];
      quick = nums[quick];
    }
    return slow;
  }

  // 看了官方的第一个解题思路
  public int findDuplicate1(int[] nums) {
    int start = 1;
    int end = nums.length - 1;
    int mid = 0;
    while (true) {
      mid = start + (end - start + 1) / 2;
      int count = 0;
      for (int e : nums) {
        if (e < mid) {
          count++;
        }
      }
      if (count < mid) {
        if (end == mid) {
          return end;
        }
        start = mid;
      } else {
        if (end == mid) {
          return start;
        }
        end = mid;
      }
    }
  }
}
