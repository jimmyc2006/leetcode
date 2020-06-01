package shuwei.leetcode.cn.three.nine.four;

import java.util.Stack;

public class Solution {
    // 1ms,90%
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        char[] content = s.toCharArray();
        Stack<Integer> times = new Stack<>();
        Stack<StringBuilder> repeats = new Stack<>();
        int num = 0;
        for (int i = 0; i < content.length; i++) {
            if (content[i] >= '0' && content[i] <= '9') {
                num = num * 10 + (content[i] - '0');
            } else if(content[i] == '[') {
                // 开始重复
                times.add(num);
                num = 0;
                repeats.add(new StringBuilder());
            } else if (content[i] == ']') {
                int count = times.pop();
                StringBuilder rep = repeats.pop();
                for (int k = 0; k <count; k++) {
                    if (!repeats.isEmpty()) {
                        repeats.peek().append(rep);
                    } else {
                        ans.append(rep);
                    }
                }
            } else {
                if (!repeats.isEmpty()) {
                    repeats.peek().append(content[i]);
                } else {
                    ans.append(content[i]);
                }
            }
        }
        return ans.toString();
    }
}
