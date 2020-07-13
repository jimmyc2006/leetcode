package shuwei.leetcode.cn.three.five.zero;

import java.util.*;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < 1 || nums2.length < 1) {
            return new int[0];
        }
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : nums2) {
            Integer count = map.get(ele);
            if (count == null) {
                map.put(ele, 1);
            } else {
                map.put(ele, count + 1);
            }
        }
        int index = 0;
        for (int ele : nums1) {
            Integer countInNums2 = map.get(ele);
            if (countInNums2 != null && countInNums2 >0) {
                ans[index++] = ele;
                countInNums2--;
                if (countInNums2 == 0) {
                    map.remove(ele);
                } else {
                    map.put(ele, countInNums2);
                }
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }
}
