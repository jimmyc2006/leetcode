package shuwei.leetcode.cn.one.eight.nine.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    /**
     * 先获取包含的连续区间，然后判断left和right是否在某个连续区间内
     * @param ranges
     * @param left
     * @param right
     * @return
     */
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0]-o2[0];
            }
        });
        List<int[]> data = new ArrayList<>();
        int[] tmpArr = ranges[0];
        if (ranges.length == 1) {
            data.add(tmpArr);
        }
        for (int i = 1; i < ranges.length; i++) {
            if (tmpArr[1] >= ranges[i][0] - 1) {
                tmpArr[1] = Math.max(tmpArr[1], ranges[i][1]);
            } else {
                data.add(tmpArr);
                tmpArr = ranges[i];
            }
            if (i == ranges.length - 1) {
                data.add(tmpArr);
            }
        }
        for (int[] datum : data) {
            if (left >= datum[0] && left <= datum[1]) {
                return right <= datum[1];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isCovered(new int[][]{{1,2},{3,4},{5,6}}, 2, 5));
        System.out.println(solution.isCovered(new int[][]{{1,10},{10, 20}}, 21, 21));
    }
}
