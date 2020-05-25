package shuwei.leetcode.cn.five.six.zero;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  // 参考官方答案后的新思路
  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> resultMap = new HashMap<>();
    int result = 0;
    int sum = 0;
    for (int i : nums) {
      sum += i;
      if (sum == k) {
        result++;
      }
      Integer need = resultMap.get(sum - k);
      if (need != null) {
        result += need;
      }
      Integer th = resultMap.get(sum);
      if (th != null) {
        resultMap.put(sum, th + 1);
      } else {
        resultMap.put(sum, 1);
      }
    }
    return result;
  }

  // 这个版本能ac，但是速度太慢了
  public int subarraySum1(int[] nums, int k) {
    int[] f = new int[nums.length];
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j > 0; j--) {
        f[j] = f[j - 1] + nums[i];
        if (f[j] == k) {
          result++;
        }
      }
      f[0] = nums[i];
      if (f[0] == k) {
        result++;
      }
    }
    return result;
  }
}
