package shuwei.leetcode.cn.seven.three.nine;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length - 1; i++){
            if (T[i] < T[i +1]) {
                ans[i] = 1;
                while (!stack.isEmpty()) {
                    int index = stack.peek();
                    if (T[index] < T[i + 1]) {
                        stack.pop();
                        ans[index] = i + 1 - index;
                    } else {
                        break;
                    }
                }
            } else {
                stack.add(i);
            }
        }
        return ans;
    }
}
