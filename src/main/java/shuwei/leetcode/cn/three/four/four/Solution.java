package shuwei.leetcode.cn.three.four.four;

public class Solution {

    /**
     * 双指针交换
     * @param s
     */
    public void reverseString(char[] s) {
        if (s == null){
            return;
        }
        for (int i = 0, j = s.length - 1; i < j; i++,j--){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }

}
