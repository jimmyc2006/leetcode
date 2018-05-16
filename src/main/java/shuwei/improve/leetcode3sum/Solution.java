package shuwei.improve.leetcode3sum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        int middle = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                middle = nums[i] + nums[j];
                if (middle > 0) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // ----------------------------
                if (Arrays.binarySearch(nums, j + 1, nums.length, 0 - middle) >= 0) {
                    results.add(Arrays.asList(nums[i], nums[j], 0 - middle));
                }

            }
        }
        return results;
    }
}
