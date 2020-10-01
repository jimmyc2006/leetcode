package shuwei.leetcode.cn.lcp.one.nine;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 看了题解，使用dp的算法实现
     * dp[i][j]中i表示从下标0开始，到i的长度,j表示状态:0左边的r，1中间的y,2右边的r
     * 最后的答案应该是dp[length - 1][2]
     * @param leaves
     * @return
     */
    public int minimumOperations(String leaves) {
        char[] data = leaves.toCharArray();
        int[][] dp = new int[data.length][3];
        if (data[0] == 'r'){
            dp[0][0] = 0;
        } else {
            dp[0][0] = 1;
        }
        dp[0][1] = data.length;
        dp[0][2] = data.length;
        if (data[1] == 'r') {
            dp[1][0] = dp[0][0];
            dp[1][1] = dp[0][0] + 1;
        } else {
            dp[1][0] = dp[0][0] + 1;
            dp[1][1] = dp[0][0];
        }
        dp[1][2] = data.length;
        // rrryyyrryyyrr
        for (int i = 2; i < data.length; i++){
            if (data[i] == 'r'){
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][0] + 1, dp[i - 1][1] + 1);
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]);
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                dp[i][2] = Math.min(dp[i - 1][1] + 1, dp[i - 1][2] + 1);
            }
        }
        return dp[data.length - 1][2];
    }

    /**
     * 特征：两边必须是r，如果不是，则替换成r
     * 主要矛盾在于中间部分，会出现r和y间隔的情况
     * 两边出现y以后，再出现r的话，就需要判断是把中间的y变成r还是将新的r变成y消耗大
     * 如果两边都确定为r的以后，就可以去掉两边的r，剩下的部分变成了：
     * 1. 可以两边r，中间y
     * 2. 全y的情况
     * 那么就取小的值 + 之前形成两边r时候的次数
     * 其中1又可以从两边去掉r，再次变成同样的问题
     * 1. 两边r，中间y
     * 2. 都是y
     * 如此反复求解貌似就可以了
     * 这个算法超时了
     * @param leaves
     * @return
     */
    public int minimumOperations1(String leaves) {
        cache = new HashMap<>();
        ans = 0;
        data = leaves.toCharArray();
        rCount = new int[data.length];
        int currCount = 0;
        for (int i = 0; i < data.length; i++){
            if (data[i] == RED){
                currCount++;
            }
            rCount[i] = currCount;
        }
        if (data[0] != RED){
            ans++;
        }
        if (data[data.length - 1] != RED){
            ans++;
        }
        int left = 1, right = data.length - 2;
        while (data[left] == RED){
            left++;
        }
        while (data[right] == RED) {
            right--;
        }
        return deal(left, right) + ans;
    }
    int ans;
    private static final char RED = 'r';
    private static final char YELLOW = 'y';
    char[] data;
    // 包含y的前缀和
    int[] rCount;
    // 缓存结果
    Map<String, Integer> cache;

    private int deal(int left, int right) {
        if (left == right){
            return 0;
        }
        // 如果都是r了，需要将中间随便一个值替换成y
        if (left > right){
            return 1;
        }
        String cacheKey = key(left, right);
        if(cache.get(cacheKey) != null){
            return cache.get(cacheKey);
        }
        int allYellowCount = rCount[right] - rCount[left];
        if (allYellowCount == 0){
            return 0;
        }
        // 左边是r的情况
        int leftRedcount = 0;
        int index = left;
        while (data[index] != RED){
            leftRedcount++;
            index++;
        }
        while (data[index] == RED){
            index++;
        }
        leftRedcount += deal(index, right);
        // 右边是r的情况
        int rightRedCount = 0;
        index = right;
        while (data[index] != RED){
            rightRedCount++;
            index--;
        }
        while (data[index] == RED){
            index--;
        }
        rightRedCount += deal(left, index);
        int min = Math.min(allYellowCount, leftRedcount);
        min = Math.min(min, rightRedCount);
        cache.put(cacheKey, min);
        return min;
    }

    private String key(int start, int end){
        return start + "-" + end;
    }
}
