package shuwei.leetcode.cn.one.six;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int mDiff = Integer.MAX_VALUE;
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0 ; i < nums.length; i++){
            int j = i +1, k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > target) {
                    int thisDiff = sum - target;
                    if (mDiff > thisDiff) {
                        mDiff = thisDiff;
                        ans = sum;
                    }
                    k--;
                } else if(sum < target) {
                    int thisDiff = target - sum;
                    if (mDiff > thisDiff) {
                        mDiff = thisDiff;
                        ans = sum;
                    }
                    j++;
                } else {
                    return target;
                }
            }
        }
        return ans;
    }

    public int threeSumClosest2(int[] nums, int target) {
        int mDiff = Integer.MAX_VALUE;
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++){
            for (int j = i +1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int thisDiff = diff(target, sum);
                    if (thisDiff < mDiff) {
                        mDiff = thisDiff;
                        ans = sum;
                    }
                }
            }
        }
        return ans;
    }

    private int diff(int s, int t){
        return s > t ? s - t : t - s;
    }

    public int threeSumClosest1(int[] nums, int target) {
        if (nums.length < 1) {
            return 0;
        }
        int ans = nums[0];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length - 1; j++) {
                int twoSum = nums[i] + nums[j];
                int tmp = minDiff;
                int third = bSearch(nums, j + 1, nums.length - 1, target - twoSum);
                if (minDiff == 0) {
                    return target;
                } else if(minDiff < tmp) {
                    ans = twoSum + third;
                }
            }
        }
        return ans;
    }

    int minDiff = Integer.MAX_VALUE;

    private int bSearch(int[] arr, int start, int end, int target) {
        int res = arr[start];
        while (start <= end) {
            int mid = (start + end) / 2;
            int thisDiff;
            if (arr[mid] > target) {
                thisDiff = arr[mid] - target;
                end = mid - 1;
            } else if(arr[mid] < target){
                start = mid + 1;
                thisDiff = target - arr[mid];
            } else {
                minDiff = 0;
                return arr[mid];
            }
            if (thisDiff < minDiff) {
                minDiff = thisDiff;
                res = arr[mid];
            }
        }
        return res;
    }
}
