package shuwei.leetcode.cn.three.seven.six;

public class Solution {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int current1 = nums[0];
        boolean isPositive1 = true;
        int ans1 = 1;
        int current2 = nums[0];
        boolean isPositive2 = false;
        int ans2 = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > current1){
                if (!isPositive1) {
                    ans1++;
                    isPositive1 = true;
                    current1 = nums[i];
                } else {
                    current1 = nums[i];
                }
            } else if (nums[i] < current1) {
                if (isPositive1) {
                    ans1++;
                    isPositive1 = false;
                    current1 = nums[i];
                } else {
                    current1 = nums[i];
                }
            }
            if (nums[i] > current2){
                if (!isPositive2) {
                    ans2++;
                    isPositive2 = true;
                    current2 = nums[i];
                } else {
                    current2 = nums[i];
                }
            } else if (nums[i] < current2){
                if (isPositive2) {
                    ans2++;
                    isPositive2 = false;
                    current2 = nums[i];
                } else {
                    current2 = nums[i];
                }
            }
        }
        return Math.max(ans1, ans2);
    }
}
