package shuwei.improve.leetcode.ZigZagConversion;
import java.util.ArrayList;
import java.util.List;


class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int range = (numRows << 1) - 2;
        char[] result = new char[arr.length];
        int index = 0;
        for(int i = 0; i < arr.length; i += range) {
            result[index++] = arr[i];
        }
        for(int i = 1; i < numRows - 1; i++) {
            int right = i << 1;
            int left = range - right;
            boolean isLeft = true;
            for(int j = i; j < arr.length;) {
                result[index++] = arr[j];
                if(isLeft) {
                    j = j + left;
                    isLeft = false;
                } else {
                    j = j + right;
                    isLeft = true;
                }
            }
        }
        for(int i = numRows - 1; i < arr.length; i += range) {
            result[index++] = arr[i];
        }
        return new String(result);
    }
    
    public String convert_2(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int range = 2 * (numRows - 1);
        char[] result = new char[arr.length];
        int index = 0;
        int left = range;
        int right = 0;
        boolean isOdd = true;
        for(int i = 0; i < numRows; i++) {
            for(int j = i; j < arr.length;) {
                result[index++] = arr[j];
                if(isOdd) {
                    j = j + (left == 0 ? range : left);
                    isOdd = false;
                } else {
                    j = j + (right == 0 ? range : right);
                    isOdd = true;
                }
            }
            left = left - 2;
            right = range - left;
            isOdd = true;
        }
        return new String(result);
    }

    
    public String convert_1(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        List<List<Character>> results = new ArrayList<>(numRows);
        char[] arr = s.toCharArray();
        for(int i = 0; i < numRows; i++) {
            results.add(new ArrayList<>());
        }
        boolean isOdd = true;
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            if(isOdd) {
                results.get(j++).add(arr[i]);
                if((j + 1) > numRows) {
                    j = j - 2;
                    isOdd = false;
                }
            } else {
                if(j == 0) {
                    isOdd = true;
                    results.get(j++).add(arr[i]);
                } else {
                    results.get(j--).add(arr[i]);
                }
            }
        }
        char[] res = new char[arr.length];
        int index = 0;
        for(List<Character> ele : results) {
            System.out.println(ele);
            for(Character c : ele) {
                res[index++] = c;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convert("PAYPALISHIRING", 4));
        System.out.println(s.convert("ABCD", 4));
        System.out.println(s.convert("AB", 2));
    }
}
