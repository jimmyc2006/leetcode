package shuwei.leetcode.cn.two.two.eight;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 遇到不连续的数值就
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int length = nums.length;
        if (length < 1) {
            return ans;
        }
        int start = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (nums[i - 1] == start) {
                    ans.add(Integer.toString(start));
                } else {
                    ans.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            }
        }
        // 处理最后一个
        if (start == nums[length - 1]) {
            ans.add(Integer.toString(nums[length - 1]));
        } else {
            ans.add(start + "->" + nums[length -1]);
        }
        return ans;
    }
}
