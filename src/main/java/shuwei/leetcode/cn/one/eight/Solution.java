package shuwei.leetcode.cn.one.eight;

import java.util.*;

public class Solution {

    /**
     * 忘了求两个数和的双指针的问题的解法了
     * 4ms 93%
     * 这个问题处理分下面几个步骤：
     * 1.去重问题：使用先排序，然后限定每个位置上的数值不能重复来实现
     * 2.优化问题:
     * 2.1 暴利法很慢，将最后一步改为使用使用二分查找
     * 2.2 选定后面两个数的时候使用双指针
     * 2.3 剪枝-根据限定条件分别对每个数的选择的时候实现剪枝(每个数时候算法不太一样)
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        find(nums, target, 4, 0, new LinkedList<>());
        return ans;
    }

    private List<List<Integer>> ans;

    private void find(int[] nums, int target, int level, int start, LinkedList<Integer> list){
        if (level == 2) {
            // 前后指针
            for (int i = start, j = nums.length - 1; i < j;) {
                if (i - 1 >= start && nums[i] == nums[i - 1]){
                    i++;
                    continue;
                } else if (nums[i] + nums[j] == target) {
                    List<Integer> result = new ArrayList<>(list);
                    result.add(nums[i]);
                    result.add(nums[j]);
                    ans.add(result);
                    i++;
                    j--;
                } else if (target > nums[i] + nums[j]) {
                    if (target > nums[j] + nums[j]){
                        return;
                    }
                    i++;
                } else if (target < nums[i] + nums[j]){
                    if (target < nums[i] + nums[i]){
                        return;
                    }
                    j--;
                }
            }
        } else {
            for (int i = start; i < nums.length - level + 1; i++){
                if (i - 1 >= start && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (level == 4){
                    if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                        break;
                    }
                    if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {
                        continue;
                    }
                } else if (level == 3) {
                    if (nums[i] + nums[i + 1] + nums[i + 2] > target) {
                        break;
                    }
                    if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < target) {
                        continue;
                    }
                }
                list.addLast(nums[i]);
                find(nums, target - nums[i], level -1, i + 1, list);
                list.removeLast();
            }
        }
    }

    /**
     * 优化性能： 当排序以后，选定3个元素以后，就可以用二分查找，在剩下的元素中寻找匹配的结果
     * 188ms,还是5%
     * @param nums
     * @param target
     * @return
     */
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        ans = new ArrayList<>();
//        Arrays.sort(nums);
//        bb(nums, target, new LinkedList<>(), 4, 0, 0);
//        return ans;
//    }
//
//    private List<List<Integer>> ans;
//
//    private void bb(int[] nums, int target, LinkedList<Integer> tmp, int level, int sum, int start) {
//        if (level == 1) {
//            // 二分查找
//            int findIndex = Arrays.binarySearch(nums, start, nums.length, target - sum);
//            if (findIndex >= start) {
//                tmp.addLast(target - sum);
//                ans.add(new ArrayList<>(tmp));
//                tmp.removeLast();
//            }
//            return;
//        }
//        for (int i = start; i < nums.length; i++) {
//            if (i - 1 >= start && nums[i] == nums[i - 1]){
//                continue;
//            }
//            tmp.addLast(nums[i]);
//            bb(nums, target, tmp, level - 1, sum + nums[i], i + 1);
//            tmp.removeLast();
//        }
//    }

    /**
     * 把当过头部的元素放在set中，跳过重复的元素
     * 这个2515ms，打败5%用户
     * @param nums
     * @param target
     * @return
     */
//    public List<List<Integer>> fourSum1(int[] nums, int target) {
//        ans = new ArrayList<>();
//        Arrays.sort(nums);
//        aa(nums, target, new LinkedList<>(), 4, 0, 0);
//        return ans;
//    }
//
//    private void aa(int[] nums, int target, LinkedList<Integer> tmp, int level, int sum, int start) {
//        if (level <= 0) {
//            if (sum == target) {
//                ans.add(new ArrayList<>(tmp));
//            }
//            return;
//        }
//        for (int i = start; i < nums.length; i++) {
//            if (i - 1 >= start && nums[i] == nums[i - 1]){
//                continue;
//            }
//            tmp.addLast(nums[i]);
//            aa(nums, target, tmp, level - 1, sum + nums[i], i + 1);
//            tmp.removeLast();
//        }
//    }
}
