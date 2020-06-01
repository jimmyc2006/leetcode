package shuwei.leetcode.cn.one.four.one.three;

import java.util.Arrays;
import java.util.List;

public class Solution {
    // 能达到最大说明他左边的小于它，且它右边的小于它
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        Boolean[] ans = new Boolean[candies.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i< candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                ans[i] = true;
            } else {
                ans[i] = false;
            }
            max = Math.max(max, candies[i]);
        }
        max = Integer.MIN_VALUE;
        for (int i = candies.length - 1; i >= 0; i--) {
            ans[i] = ans[i] && (candies[i] + extraCandies >= max);
            max = Math.max(max, candies[i]);
        }
        return Arrays.asList(ans);
    }
}
