package shuwei.improve.leetcode.myAtoi;
class Solution {
    
    public int myAtoi(String str) {
        char[] arr = str.toCharArray();
        boolean hadFirst = false;
        boolean isPositive = true;
        long result = 0;
        for(char c : arr) {
            if(!hadFirst) {
                if(c == ' ') {
                    continue;
                } else if(c == '+') {
                    hadFirst = true;
                } else if (c == '-'){
                    isPositive = false;
                    hadFirst = true;
                } else if(Character.isDigit(c)){
                    hadFirst = true;
                    result = Character.digit(c, 10);
                } else {
                    return 0;
                }
            } else {
                if(!Character.isDigit(c)) {
                    break;
                } else {
                    result = result * 10 + Character.digit(c, 10);
                    if(result >= Integer.MAX_VALUE) {
                        if(isPositive) {
                            return Integer.MAX_VALUE;
                        } else {
                            if(result - 1 >= Integer.MAX_VALUE) {
                                return Integer.MIN_VALUE;
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
        }
        
        return isPositive ? (int) result : 0 - (int)result;
    }
    
    public int myAtoi_1(String str) {
        char[] arr = str.toCharArray();
        boolean hadFirst = false;
        boolean isPositive = true;
        int numStart = 0;
        int numEnd = 0;
        for(int i = 0; i < arr.length; i++) {
            // 遇到第一位之前
            if(!hadFirst) {
                if(arr[i] == ' ') {
                    continue;
                } else if(arr[i] == '+' || Character.isDigit(arr[i])) {
                    numStart = i;
                    numEnd = i + 1;
                    hadFirst = true;
                } else if (arr[i] == '-'){
                    numStart = i;
                    numEnd = i + 1;
                    isPositive = false;
                    hadFirst = true;
                } else {
                    return 0;
                }
            } else {
                if(!Character.isDigit(arr[i])) {
                    numEnd = i;
                    break;
                } else {
                    numEnd = i + 1;
                }
            }
        }
        if(!hadFirst) {
            return 0;
        }
        if((str.charAt(numStart) == '+' || str.charAt(numStart) == '-') && numEnd == numStart + 1) {
            return 0;
        }
        try{
            return Integer.parseInt(str.substring(numStart, numEnd));
        } catch (NumberFormatException  e) {
            if(isPositive) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
    }
}
