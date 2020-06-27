package shuwei.leetcode.cn.four.one;

public class Solution {

  public int firstMissingPositive(int[] nums) {
    int min = 1;
    int max = nums.length;
    for (int i = 0; i < nums.length; i++) {
      if (!(i + 1 == nums[i])) {
        int val = nums[i];
        while (val >= min && val <= max && nums[val - 1] != val) {
          int tmp = nums[val - 1];
          nums[val - 1] = val;
          val = tmp;
        }
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return max + 1;
  }

  public int firstMissingPositive1(int[] nums) {
    int min = 1;
    int max = nums.length;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < min || nums[i] > max) {
        nums[i] = max + 1;
      } else if(nums[i] == i + 1) {
        nums[i] = min - 1;
      } else {
        int index = nums[i] - 1;
        while (nums[index] >= min && nums[index] <= max && index + 1 != nums[index]) {
          int tmp = nums[index];
          nums[index] = index + 1;
          index = tmp - 1;
        }
        nums[index] = index + 1;
        if (i + 1 == nums[i]) {
          nums[i] = min - 1;
        } else {
          nums[i] = max + 1;
        }
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) {
        return i + 1;
      }
    }
    return max + 1;
  }
}
