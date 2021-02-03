package shuwei.leetcode.cn.four.two.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    /**
     * 这个能算出来了，但是需要15ms，效率比较差
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int length = s.length();
        if (length <= 1 || k >= length) {
            return s.length();
        }
        if (k == 0) {
            int curr = 1;
            char last = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == last) {
                    curr++;
                } else {
                    ans = Math.max(ans, curr);
                    curr = 1;
                    last = s.charAt(i);
                }
            }
            return Math.max(ans, curr);
        }
        List<Integer>[] indexs = new List[26];
        for (int i = 0; i < 26; i++) {
            indexs[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            indexs[s.charAt(i) - 'A'].add(i);
        }
        Arrays.sort(indexs, Comparator.comparingInt(l -> l.size()));
        char first = s.charAt(0);
        for (int i = 25; i >= 0; i--) {
            if (indexs[i].size() == 0 || indexs[i].size() + k <= ans) {
                break;
            }
            ans = Math.max(ans, cal(indexs[i], k, length));
        }
        return ans;
    }

    private int cal(List<Integer> indexs, int k, int length) {
        int size = indexs.size();
        int start = 0, curr = 0, result = 0;
        int remain = k;
        while (curr < size - 1) {
            int next = curr + 1;
            int diff = indexs.get(next) - indexs.get(curr) - 1;
            if (diff == 0) {
                curr++;
            } else {
                // 是否有足够的remain让他们连起来
                if (remain >= diff) {
                    remain = remain - diff;
                    curr = next;
                } else {
                    result = Math.max(result, indexs.get(curr) - indexs.get(start) + 1 + remain);
                    if (start == curr) {
                        start++;
                        curr++;
                        remain = k;
                    } else {
                        while (indexs.get(start + 1) == indexs.get(start) + 1) {
                            start++;
                        }
                        if (start == curr) {
                            remain = k;
                        } else {
                            start++;
                            if (start < curr) {
                                remain = remain + indexs.get(start) - indexs.get(start - 1) - 1;
                            } else {
                                remain = k;
                            }
                        }
                    }
                }
            }
        }
        // 处理多余k的情况
        if (remain > 0) {
            int tail = length - indexs.get(size - 1) - 1;
            if (tail >= remain) {
                return Math.max(result, indexs.get(size - 1) - indexs.get(start) + 1 + remain);
            } else {
                remain = remain - tail;
            }
            int head = indexs.get(0);
            if (head >= remain) {
                return Math.max(result, indexs.get(size - 1) - indexs.get(start) + 1 + tail + remain);
            } else {
                return Math.max(result, indexs.get(size - 1) - indexs.get(start) + 1 + tail + head);
            }
        } else {
            return Math.max(result, indexs.get(size - 1) - indexs.get(start) + 1);
        }
    }
}
