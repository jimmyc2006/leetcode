package shuwei.leetcode.cn.seven.six.five;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 0, 2, 1, 3尝试从左往右交换
     * 比如第0位置是0，第1位置是2，那么凑0,1 或者3,2
     * 2和1换 0, 1, 2, 3
     * 0和3换 3, 2, 1, 0
     *
     * 特征数据2：
     * 0, 2, 4, 6, 1, 7, 5, 3
     * @param row
     * @return
     */
    public int minSwapsCouples(int[] row) {
        int[] indexArr = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            indexArr[row[i]] = i;
        }
        return minSwapsCouples(row, indexArr, 0);
    }

    // 每次都换后面的数
    private int minSwapsCouples(int[] row, int[] indexArr, int start) {
        if (start == row.length) {
            return 0;
        }
        int next = start + 1;
        if ((row[start] & 1) == 0) {
            // 偶数
            if (row[next] == row[start] + 1) {
                return minSwapsCouples(row, indexArr, next + 1);
            } else {
                int finder = indexArr[row[start] + 1];
                swap(row, next, finder, indexArr);
                return minSwapsCouples(row, indexArr, next + 1) + 1;
            }
        } else {
            // 奇数
            if (row[next] == row[start] - 1) {
                return minSwapsCouples(row, indexArr, next + 1);
            } else {
                int finder = indexArr[row[start] - 1];
                swap(row, next, finder, indexArr);
                return minSwapsCouples(row, indexArr, next + 1) + 1;
            }
        }
    }

    private void swap(int[] arr, int a, int b, int[] indexArr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        indexArr[arr[a]] = a;
        indexArr[arr[b]] = b;
    }
}
