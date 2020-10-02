package shuwei.leetcode.cn.seven.seven.one;

public class Solution {

    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null){
            return 0;
        }
        boolean[] isExiest = new boolean['z' - 'A' + 1];
        for (char c : J.toCharArray()) {
            isExiest[c - 'A'] = true;
        }
        int ans = 0;
        for (char c : S.toCharArray()) {
            if (isExiest[c - 'A']) {
                ans++;
            }
        }
        return ans;
    }

}
