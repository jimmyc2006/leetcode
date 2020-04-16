package shuwei.leetcode.cn.twoPlus;

import java.util.HashMap;
import java.util.Map;

/** 
* @author shuwei 
* @version 创建时间：2020年4月14日 下午7:06:05 
* 类说明 
*/
public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] result = s.twoSum(new int[] {2, 7, 11, 15}, 9);
    for (int i : result) {
      System.out.println(i);
    }
  }
  
  public int[] twoSum(int[] nums, int target) {
    // key是值，value是下标
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int val = nums[i];
      int needVal = target - val;
      Integer index = map.get(needVal);
      if (index != null) {
        return new int[] {index, i};
      }
      map.put(val, i);
    }
    return null;
  }
}
