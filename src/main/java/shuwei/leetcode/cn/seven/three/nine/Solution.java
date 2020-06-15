package shuwei.leetcode.cn.seven.three.nine;

import java.util.Map;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        int[] ans = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            map = map.tailMap(T[i]);
            if (!map.isEmpty()) {
                ans[i] = map.get(map.firstKey()) - i;
            } else {
                ans[i] = 0;
            }
            map.put(T[i], i);
        }
        return ans;
    }

    public int[] dailyTemperatures1(int[] T) {
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
