package shuwei.leetcode.cn.mst.six.four;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sumNums(4));
    }
    public int sumNums(int n) {
        int ans = 0;
        boolean b = n > 0 && (ans = n + sumNums(n -1)) > 0;
        return ans;
    }
}
