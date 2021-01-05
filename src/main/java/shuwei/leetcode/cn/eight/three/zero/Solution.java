package shuwei.leetcode.cn.eight.three.zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> largeGroupPositions(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        List<List<Integer>> ans  = new ArrayList<>();
        if (s.length() < 3) {
            return ans;
        }
        int start = 0;
        for (int i = 1; i < length; i++) {
            if (chars[i] != chars[i - 1]) {
                if (i - start >= 3) {
                    ans.add(Arrays.asList(new Integer[]{start, i - 1}));
                }
                start = i;
            }
        }
        // 处理最后一个
        if(chars[length - 1] == chars[length - 2] && length - start >= 3) {
            ans.add(Arrays.asList(new Integer[]{start, length - 1}));
        }
        return ans;
    }

}
