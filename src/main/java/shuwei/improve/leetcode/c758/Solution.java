package shuwei.improve.leetcode.c758;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author shuwei
 * @version 创建时间：2018年1月7日 下午3:47:58 类说明
 */
public class Solution {
    public String boldWords(String[] words, String S) {
        Map<Character, Set<Character>> next = new HashMap<>();
        for(String word : words) {
            char[] arr = word.toCharArray();
            for(int i = 0; i < arr.length - 1; i++) {
                Set<Character> afters = next.get(arr[i]);
                if(afters == null) {
                    afters = new HashSet<>();
                    next.put(arr[i], afters);
                }
                afters.add(arr[i+1]);
            }
        }
        boolean isBold = false;
        StringBuilder sb = new StringBuilder(S.length());
        char[] cArr = S.toCharArray();
        for(int i = 0; i < cArr.length; i++) {
            if(isBold) {
                sb.append(cArr[i]);
                if(i == cArr.length - 1) {
                    sb.append("</b>");
                }
                Set<Character> afters = next.get(cArr[i]);
                if(afters == null) {
                    sb.append("</b>");
                } else {
                    if(!afters.contains(cArr[i+1])) {
                        sb.append("</b>");
                        isBold=false;
                    }
                }
            } else {
                Set<Character> afters = next.get(cArr[i]);
                if(afters == null) {
                    sb.append(cArr[i]);
                } else {
                    if(afters.contains(cArr[i + 1]) && i != cArr.length - 1) {
                        sb.append("<b>").append(cArr[i]);
                        isBold = true;
                    } else {
                        sb.append("<b>").append(cArr[i]).append("</b>");
                    }
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.boldWords(new String[]{"ab", "bc"}, "aabcd"));
    }
}
