package shuwei.leetcode.cn.one.seven.one.three;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{16,7,20,11,15,13,10,14,6,8}, new int[]{11,14,15,7,5,5,6,10,11,6})); //6
        System.out.println(solution.minOperations(new int[]{11, 16, 20, 1, 2, 13, 7, 6, 12, 3}, new int[]{11, 13, 3, 7, 7, 1, 10, 12, 14, 1})); //6
        System.out.println(solution.minOperations(new int[]{5, 1, 3}, new int[]{9, 4, 2, 3, 4})); // 2
        System.out.println(solution.minOperations(new int[]{6, 4, 8, 1, 3, 2}, new int[]{4, 7, 6, 2, 3, 8, 6, 1})); //3
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
    public int minOperations(int[] target, int[] arr) {
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
