package shuwei.leetcode.cn.one.seven.one.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{16,7,20,11,15,13,10,14,6,8}, new int[]{11,14,15,7,5,5,6,10,11,6})); //6
        System.out.println(solution.minOperations(new int[]{11, 16, 20, 1, 2, 13, 7, 6, 12, 3}, new int[]{11, 13, 3, 7, 7, 1, 10, 12, 14, 1})); //6
        System.out.println(solution.minOperations(new int[]{5, 1, 3}, new int[]{9, 4, 2, 3, 4})); // 2
        System.out.println(solution.minOperations(new int[]{6, 4, 8, 1, 3, 2}, new int[]{4, 7, 6, 2, 3, 8, 6, 1})); //3
    }

    /**
     * 2021-07-30 review
     * 去掉没有用的元素
     * 将数值转化为下标
     * 求最长的单调递增子序列
     * @param target
     * @param arr
     * @return
     */
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            indexMap.put(target[i], i);
        }
        List<Integer> clears = new ArrayList<>();
        for (int i : arr) {
            Integer index = indexMap.get(i);
            if (index != null) {
                clears.add(index);
            }
        }
        if (clears.isEmpty()) {
            return target.length;
        }
        int[] dealedArr = clears.stream().mapToInt(i -> i).toArray();
        // 最长单调递增子序列
        int i = largeSubBigger(dealedArr);
        return target.length - i;
    }

    private int largeSubBigger(int[] arr) {
        int[] d = new int[arr.length + 1];
        d[1] = arr[0];
        int currIndex = 2;
        for (int i = 1; i < arr.length; i++) {
            int index = findBiggerIndex(d, 1, currIndex, arr[i]);
            if (index == currIndex) {
                d[currIndex++] = arr[i];
            } else {
                d[index] = arr[i];
            }
        }
        return currIndex - 1;
    }

    private int findBiggerIndex(int[] arr, int start, int end, int val) {
        if (start == end) {
            return end;
        }
        int mid = (start + end) / 2;
        if (arr[mid] < val) {
            return findBiggerIndex(arr, mid + 1, end, val);
        } else if (arr[mid] == val) {
            return mid;
        } else {
            return findBiggerIndex(arr, start, mid, val);
        }
    }

    /**
     * 输入：target = [5,1,3], arr = [9,4,2,3,4]
     * 输出：2
     * 输入：target = [6,4,8,1,3,2], arr = [4,7,6,2,3,8,6,1]
     * 输出：3
     * <p>
     * [11,16,20,1,2,13,7,6,12,3]
     * [11,13,3,7,7,1,10,12,14,1]
     * 7
     * 预期结果6
     *
     * [16,7,20,11,15,13,10,14,6,8]
     * [11,14,15,7,5,5,6,10,11,6]
     * 输出：
     * 7
     * 预期结果：
     * 6
     *
     * @param target
     * @param arr
     * @return
     */
    public int minOperations_20210730(int[] target, int[] arr) {
        int[] count = new int[arr.length];
        int currMax = 0;
        for (int i = target.length - 1; i >= 0; i--) {
            currMax = 0;
            for (int j = arr.length - 1; j >= 0; j--) {
                if (target[i] == arr[j]) {
                    count[j] = currMax + 1;
                    if (count[j] == target.length - i) {
                        break;
                    }
                } else {
                    currMax = Math.max(currMax, count[j]);
                }
            }
        }
        for (int i : count) {
            currMax = Math.max(currMax, i);
        }
        return target.length - currMax;
    }
}
