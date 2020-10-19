package shuwei.leetcode.cn.five.two;

public class Solution {

    /**
     * 二维数组表示当前棋盘的状态
     * 从0到n-1，每个棋子占一行，这样解决了行的问题
     * 每一个棋子从0到n-1列遍历,借助一个status[n]来表示某一列是否已经被前面的棋子占用
     * 遍历到每一个棋子的时候，检查斜线是否被占用，如果被占用就换，否则继续下一个棋子
     * 最后一个棋子落下以后，就生成了一种新的方案
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        ans = 0;
        N = n;
        status = new boolean[n][n];
        isUsed = new boolean[n];
        deal(0);
        return ans;
    }

    private int N;
    private int ans;
    private boolean[][] status; // 棋盘情况
    private boolean[] isUsed; // 某一列是否被占用

    /**
     *
     * @param index 第几个棋子
     */
    private void deal(int index) {
        if (index == N) {
            ans++;
            return;
        }
        for (int i = 0; i < N; i++) {
            // 如果该列已经被别的棋子使用
            if (isUsed[i]) {
                continue;
            } else {
                if (isConflict(index, i)) {
                    continue;
                } else {
                    isUsed[i] = true;
                    status[index][i] = true;
                    deal(index +1);
                    status[index][i] = false;
                    isUsed[i] = false;
                }
            }
        }
    }
    // 检查斜线是否有冲突
    private boolean isConflict(int index, int columnIndex){
        int x = index;
        int y = columnIndex;
        while (--x >= 0 && --y >= 0) {
            if (status[x][y]) {
                return true;
            }
        }
        x = index;
        y = columnIndex;
        while (++x < N && ++y < N) {
            if (status[x][y]){
                return true;
            }
        }
        x = index;
        y = columnIndex;
        while (--x >= 0 && ++y < N) {
            if (status[x][y]) {
                return true;
            }
        }
        x = index;
        y = columnIndex;
        while (++x < N && --y >= 0) {
            if (status[x][y]) {
                return true;
            }
        }
        return false;
    }
}
