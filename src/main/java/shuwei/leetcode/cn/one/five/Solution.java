package shuwei.leetcode.cn.one.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));
    System.out.println(s.threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
    System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    System.out.println(s.threeSum(new int[]{0, 0, 0, 0}));
    System.out.println(s.threeSum(new int[]{1, -1, -1, 0}));
    System.out.println(s.threeSum(new int[]{-2, 0, 1, 1, 2}));
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if ( i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1, k = nums.length - 1; j < k; ) {
        if (j < k && j > i + 1 && nums[j] == nums[j - 1]) {
          j++;
          continue;
        }
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
          ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
          j++;
          k--;
        } else if (sum > 0) {
          k--;
        } else {
          j++;
        }
      }
    }
    return ans;
  }
}
