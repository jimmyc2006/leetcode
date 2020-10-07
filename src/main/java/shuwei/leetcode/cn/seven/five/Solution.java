package shuwei.leetcode.cn.seven.five;

public class Solution {

    /**
     * 记录第一个0，第一个1和第一个2的位置
     * 如果当前位置为1，则将这个位置跟第一个2交换，第一个2的位置后移一位
     * 如果当前位置为0，则将这个位置跟第一个1交换，然后再按照这个位置是1来计算
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }
        int firstOne = -1, firstTwo = -1;
        int length = nums.length;
        for (int i =0 ;i < length;) {
            if (nums[i] == 0) {
                if (firstOne >= 0){
                    swap(nums, i, firstOne);
                    firstOne++;
                    if (nums[firstOne] != 1){
                        firstOne = -1;
                    }
                } else if (firstTwo >= 0){
                    swap(nums, i, firstTwo);
                    firstTwo++;
                    i++;
                } else {
                    i++;
                }
            } else if (nums[i] == 1) {
                if (firstTwo >= 0){
                    swap(nums, i, firstTwo);
                    if (firstOne < 0) {
                        firstOne = firstTwo;
                    }
                    firstTwo++;
                }
                if (firstOne < 0){
                    firstOne = i;
                }
                i++;
            } else {
                if (firstTwo < 0){
                    firstTwo = i;
                }
                i++;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
