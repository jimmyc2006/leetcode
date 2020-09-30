package shuwei.leetcode.cn.two.zero;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public boolean isValid(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        Deque<Character> stack = new ArrayDeque<>();
        char[] content = s.toCharArray();
        for (int i = 0; i < content.length; i++){
            if (content[i] == ')'){
                if (stack.size() < 1 || stack.pollLast() != '(') {
                    return false;
                }
            } else if (content[i] == ']'){
                if(stack.size() < 1 || stack.pollLast() != '[') {
                    return false;
                }
            } else if (content[i] == '}') {
                if (stack.size() < 1 || stack.pollLast() != '{') {
                    return false;
                }
            } else {
                stack.add(content[i]);
            }
        }
        return stack.size() == 0;
    }
}
