package shuwei.leetcode.cn.one.zero.one.four;

public class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        if (A == null || A.length <1) {
            return 0;
        }
        if (A.length == 1){
            return A[0];
        }
        int ans = 0, beforeMax  = A[0];
        for (int i = 1; i < A.length; i++) {
            int curMax = beforeMax + A[i] - i;
            ans = Math.max(ans, curMax);
            beforeMax = Math.max(beforeMax, A[i] + i);
        }
        return ans;
    }
}
