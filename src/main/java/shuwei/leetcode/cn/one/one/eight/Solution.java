package shuwei.leetcode.cn.one.one.eight;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows < 1) {
            return ans;
        }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ans.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            ans.add(row);
            for (int j = 0; j <= i; j++) {
                int val = 0;
                if (j - 1 >= 0) {
                    val += ans.get(i - 1).get(j - 1);
                }
                if (j < ans.get(i -1 ).size()) {
                    val += ans.get(i - 1).get(j);
                }
                row.add(val);
            }
        }
        return ans;
    }
}
