package shuwei.leetcode.cn.mst.four.six;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    // 0 - 25 有效范围
    // 输入: 12258
    // 输出: 5
    public int translateNum(int num) {
        if (num <= 0) {
            return 1;
        }
        Stack<Integer> stack  = new Stack<>();
        while (num > 0) {
            stack.add(num % 10);
            num = num / 10;
        }
        int[] f = new int[stack.size()];
        f[0] = 1;
        int i = 1;
        int tmp = stack.pop();
        while (!stack.isEmpty()) {
            int next = stack.pop();
            if (tmp != 0 && tmp * 10 + next <= 25) {
                f[i] = f[i - 1] + ((i - 2) >= 0 ? f[i - 2] : 1);
            } else {
                f[i] = f[i - 1];
            }
            tmp = next;
            i++;
        }
        return f[f.length - 1];
    }


    // bfs,效率不好
    public int translateNum1(int num) {
        Stack<Integer> stack = new Stack();
        if (num == 0){
            stack.add(0);
        } else {
            while (num > 0) {
                stack.add(num % 10);
                num = num / 10;
            }
        }
        int size = stack.size();
        int[] arr = new int[size];
        int index = 0;
        while (!stack.isEmpty()) {
            arr[index++] = stack.pop();
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        if (1 < arr.length && (arr[0] == 1 || (arr[0] <= 2 && arr[1] <= 5))) {
            queue.add(1);
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int val = queue.poll();
            if (val == size - 1) {
                ans++;
            } else {
             if (val + 1 < size) {
                 queue.add(val +1);
             }
             if (val + 2 < size && (arr[val + 1] == 1 || (arr[val + 1] == 2 && arr[val + 2] <= 5))) {
                 queue.add(val + 2);
             }
            }
        }
        return ans;
    }
}
