package shuwei.leetcode.cn.seven.three.eight;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int monotoneIncreasingDigits(int N) {
        LinkedList<Integer> list = new LinkedList<>();
        int nineCount = 0;  // 记录最后有几个9
        while (N > 0) {
            int curr = N % 10;
            if (list.size() > 0) {
                if (curr > list.peekFirst()) {
                    curr--;
                    nineCount += list.size();
                    list.clear();
                    list.addFirst(curr);
                } else {
                    list.addFirst(curr);
                }
            } else {
                list.addFirst(curr);
            }
            N = N / 10;
        }
        int ans = 0;
        for (int ele : list) {
            ans = ans * 10 + ele;
        }
        while (nineCount > 0){
            ans = ans * 10 + 9;
            nineCount--;
        }
        return ans;
    }
}
