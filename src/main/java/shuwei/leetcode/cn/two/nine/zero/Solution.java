package shuwei.leetcode.cn.two.nine.zero;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean wordPattern(String pattern, String s) {
        if (s.length() == 0) {
            return pattern.length() == 0;
        }
        // 映射每个字母代表的字符串
        Map<String, Character> map = new HashMap<>();
        char[] chars = pattern.toCharArray();
        String[] strs = s.split(" ");
        if (chars.length != strs.length) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            Character c = map.get(strs[i]);
            if (c == null) {
                if (map.values().contains(chars[i])) {
                    return false;
                }
                map.put(strs[i], chars[i]);
            } else {
                if (c != chars[i]){
                    return false;
                }
            }
        }
        return true;
    }

}
