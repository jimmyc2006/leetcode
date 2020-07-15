package shuwei.leetcode.cn.one.two.zero;

import java.util.List;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() < 1) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int[] f = new int[triangle.size()];
        // 最后一行
        List<Integer> level = triangle.get(triangle.size() - 1);
        for (int i = 0; i < level.size(); i++) {
            f[i] = level.get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--){
            level = triangle.get(i);
            for (int j = 0; j < level.size(); j++) {
                f[j] = level.get(j) + Math.min(f[j], f[j + 1]);
            }
        }
        return f[0];
    }

}
