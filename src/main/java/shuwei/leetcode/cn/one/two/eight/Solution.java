package shuwei.leetcode.cn.one.two.eight;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  // 官方思路 5ms 82%
  public int longestConsecutive(int[] nums) {
    Set<Integer> data = new HashSet<>();
    for (int i : nums) {
      data.add(i);
    }
    int ans = 0;
    for (Integer i : data) {
      if ( data.contains(i - 1)) {
        continue;
      }
      int count = 1;
      int j = i + 1;
      while (data.contains(j)) {
        count++;
        j++;
      }
      ans = Math.max(ans, count);
    }
    return ans;
  }

  // 6ms 58%
  public int longestConsecutive1(int[] nums) {
    int ans = 0;
    Map<Integer, int[]> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int[] info = map.get(nums[i]);
      if (info != null) {
        continue;
      }
      int left = nums[i] - 1;
      int right = nums[i] + 1;
      int[] leftInfo = map.get(left);
      if (leftInfo != null) {
        leftInfo[1]++;
        map.put(nums[i], leftInfo);
        ans = Math.max(ans, leftInfo[1]);
      }
      int[] rightInfo = map.get(right);
      if (rightInfo != null) {
        int count = 0;
        if(leftInfo != null) {
          count = leftInfo[1] + rightInfo[1];
          leftInfo[1] = count;
          // 最右边更新,只要两边的数据正确即可
          map.put(leftInfo[0] + leftInfo[1] - 1, leftInfo);
        } else {
          count = rightInfo[1] + 1;
          rightInfo[0] = nums[i];
          rightInfo[1] = count;
        }
        map.put(nums[i], rightInfo);
        ans = Math.max(ans, count);
      }
      if (leftInfo == null && rightInfo == null) {
        map.put(nums[i], new int[]{nums[i], 1});
        ans = Math.max(1, ans);
      }
    }
    return ans;
  }
}
