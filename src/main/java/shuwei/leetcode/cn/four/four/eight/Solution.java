package shuwei.leetcode.cn.four.four.eight;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 4, 3, 2, 7, 8, 2, 3, 1
     * 0, 1, 2, 3, 4, 5, 6, 7
     * 0位置是4，那么就
     * 取出3上的值为7，然后将4放在3上
     * 取出6上的值为3，然后将7放在6上
     * 取出2上的值为2，然后将3放在2上
     * 取出1上的值为3，将2放在1上
     * 取出3上的值为4，不需要处理；
     * 从0开始处理，如果位置上的值不等于位置的值+1，那么就需要处理
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) {
                continue;
            }
            int tmp = nums[i];
            int index = tmp - 1;
            while (tmp != nums[index]){
                int nextTmp = nums[index];
                nums[index] = tmp;
                tmp = nextTmp;
                index = tmp - 1;
            }
            if (nums[i] != i +1) {
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                ans.add(i +1);
            }
        }
        return ans;
    }
}
