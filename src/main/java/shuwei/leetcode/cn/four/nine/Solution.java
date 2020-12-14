package shuwei.leetcode.cn.four.nine;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> strings = map.get(key);
            if (strings == null) {
                strings = new ArrayList<>();
                map.put(key, strings);
            }
            strings.add(str);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        List<int[]> arrList = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();
        for (String str : strs) {
            int[] data = new int[26];
            int sum = this.transfer(str, data);
            int index = this.findIndex(arrList, sumList, data, str, sum);
            if (index == - 1) {
                arrList.add(data);
                sumList.add(str.length());
                List<String> newList = new ArrayList<>();
                newList.add(str);
                ans.add(newList);
            } else {
                ans.get(index).add(str);
            }
        }
        return ans;
    }

    private int transfer(String str, int[] data) {
        char[] chars = str.toCharArray();
        int sum = 0;
        for (char ch : chars) {
            data[ch - 'a']++;
            sum += ch - 'a';
        }
        return sum;
    }

    private int findIndex(List<int[]> list, List<Integer> sumList, int[] find, String str, int sum) {
        int length = str.length();
        for (int i = 0 ; i < list.size(); i++) {
            if (sumList.get(i) == length && Arrays.equals(list.get(i), find)) {
                return i;
            }
        }
        return -1;
    }

}
