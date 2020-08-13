package shuwei.leetcode.cn.one.three.zero;

public class Solution {

    public void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1) {
            return;
        }
        sign = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++ ){
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && (!sign[i][j])) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    boolean[][] sign;

    private void dfs(char[][] board, int x, int y) {
        if (board[x][y] == 'X' || sign[x][y]) {
            return;
        } else {
            sign[x][y] = true;
            if (x - 1 >= 0) {
                dfs(board, x - 1, y);
            }
            if (x + 1 < board.length) {
                dfs(board, x + 1, y);
            }
            if (y - 1 >= 0) {
                dfs(board, x, y - 1);
            }
            if (y + 1 < board[x].length) {
                dfs(board, x, y + 1);
            }
        }
    }

}
