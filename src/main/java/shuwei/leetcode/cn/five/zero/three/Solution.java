package shuwei.leetcode.cn.five.zero.three;

import java.util.LinkedList;

public class Solution {

  public int[] nextGreaterElements(int[] nums) {
    int[] ans = new int[nums.length];
    if (nums.length < 1) {
      return ans;
    }
    LinkedList<Integer> biggerList = new LinkedList<>();
    int i = 0;
    while (true) {
      while (biggerList.size() > 0 && nums[biggerList.getLast()] < nums[i]) {
        ans[biggerList.getLast()] = nums[i];
        biggerList.removeLast();
      }
      if (biggerList.size() > 0 && i == biggerList.getFirst()) {
        for (Integer integer : biggerList) {
          ans[integer] = -1;
        }
        break;
      }
      biggerList.addLast(i);
      if (i == nums.length - 1) {
        i  = 0;
      } else {
        i++;
      }
    }
    return ans;
  }
}
