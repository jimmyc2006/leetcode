package shuwei.leetcode.cn.mst.one.seven.one.three;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionBak20200807 {
    public int respace(String[] dictionary, String sentence) {
        if (sentence.length() < 1) {
            return 0;
        }
        if (dictionary.length < 1) {
            return sentence.length();
        }
        Set<String> cache = new HashSet<>();
//        Map<Character, Set<String>> oneLevelCache = new HashMap<>();
        Map<String, Set<String>> twoLevelCache = new HashMap<>();
        for (int i = 0; i < dictionary.length; i++) {
            String str = dictionary[i];
            cache.add(str);
//            Set strs1 = oneLevelCache.computeIfAbsent(str.charAt(str.length() - 1), k -> new HashSet<>());
//            strs1.add(str);
            if (str.length() > 2) {
                Set strs2 = twoLevelCache.computeIfAbsent(str.substring(str.length() - 2), k -> new HashSet<>());
                strs2.add(str);
            }
        }
        int[] f = new int[sentence.length() + 1];
        // f[0]表示字符串长度为0时候
        for (int i = 1; i <= sentence.length(); i++) {
            String str = sentence.substring(0, i);
            if (cache.contains(str)) {
                f[i] = 0;
            } else {
                f[i] = f[i - 1] + 1;
                if (i > 1) {
                    String stTmp = str.substring(str.length() - 1);
                    if (cache.contains(stTmp)) {
                        f[i] = Math.min(f[i], f[i - 1]);
                    }
                }
                if (i > 2) {
                    String stTmp = str.substring(str.length() - 2);
                    if (cache.contains(stTmp)) {
                        f[i] = Math.min(f[i], f[i - 2]);
                    }
                    Set<String> ones = twoLevelCache.get(stTmp);
                    if (ones != null) {
                        for (String s : ones) {
                            if (str.endsWith(s)) {
                                f[i] = Math.min(f[i], f[i - s.length()]);
                            }
                        }
                    }
                }
            }
        }
        return f[f.length - 1];
    }
}
