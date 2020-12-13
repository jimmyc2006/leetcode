package shuwei.leetcode.cn.two.one.seven;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (Integer ele : nums) {
            if (!set.add(ele)){
                return true;
            }
        }
        return false;
    }
}
