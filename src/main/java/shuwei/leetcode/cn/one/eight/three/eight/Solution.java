package shuwei.leetcode.cn.one.eight.three.eight;

import java.util.Arrays;

public class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int remain = k;
        int currIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; ) {
            int diff = nums[currIndex] - nums[i];
            if (diff <= remain) {
                remain -= diff;
                i--;
            } else {
                ans = Math.max(ans, currIndex - i);
                if (currIndex - i > 1) {
                    remain += (currIndex - i - 1) * (nums[currIndex] - nums[currIndex - 1]);
                }
                currIndex--;
            }
        }
        ans = Math.max(ans, currIndex + 1);
        return ans;
    }
}
