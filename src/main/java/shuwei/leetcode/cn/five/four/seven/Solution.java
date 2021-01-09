package shuwei.leetcode.cn.five.four.seven;

public class Solution {
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        ans = n;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    connect(isConnected, i, j);
                }
            }
        }
        return ans;
    }
    private int n;
    private boolean[] visited;
    private int ans;

    private void connect(int[][] isConnected, int start, int y) {
        if (visited[y]) {
            return;
        }
        ans--;
        visited[y] = true;
        for (int i = start + 1; i < n; i++) {
            if (i != y && isConnected[i][y] == 1) {
                connect(isConnected, start, i);
            }
        }
    }
}
