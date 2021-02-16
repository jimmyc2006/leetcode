package shuwei.leetcode.cn.five.six.one;

import java.util.Arrays;

public class Solution {

    /**
     * 先排序，然后拿偶数索引的值的和
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                ans += nums[i];
            }
        }
        return ans;
    }

}
