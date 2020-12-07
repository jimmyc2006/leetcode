package shuwei.leetcode.cn.six.two.one;

public class Solution {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        n = n + 1;
        // 计算最多的任务
        int max = 0;
        int[] counts = new int[26];
        int categoryCount = 0;
        for (char ele : tasks) {
            int index = ele - 'A';
            if (counts[index] == 0) {
                categoryCount++;
            }
            counts[index]++;
            max = Math.max(max, counts[ele - 'A']);
        }
        int maxCount = 0;
        for (int ele : counts) {
            if (ele == max) {
                maxCount++;
            }
        }
        if (n > categoryCount) {
            return (max - 1) * n + maxCount;
        }
        int average = tasks.length / n + (tasks.length % n == 0 ? 0 : 1);
        if (max > average) {
            return (max  -1) * n + maxCount;
        } else if (max == average){
            // 正好填满
            if (tasks.length % n == 0) {
                return tasks.length;
            } else {
                return (max  -1) * n + Math.max(tasks.length % n, maxCount);
            }
        } else {
            return tasks.length;
        }
    }

}
