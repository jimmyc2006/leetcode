package shuwei.leetcode.cn.seven.nine;

public class Solution {


  /**
   * 最简单的直接dfs，估计要超时
   */
  public boolean exist(char[][] board, String word) {
    boolean[][] status = new boolean[board.length][board[0].length];
    char[] words = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (find(i, j, board, words, 0, status)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean find(int x, int y, char[][] board, char[] words, int index, boolean[][] status) {
    if (status[x][y]) {
      return false;
    }
    if (board[x][y] == words[index]) {
      status[x][y] = true;
      int nextIndex = index + 1;
      if (nextIndex == words.length) {
        return true;
      }
      if (x + 1 < board.length && find(x + 1, y, board, words, nextIndex, status)) {
        return true;
      }
      if (x - 1 >= 0 && find(x - 1, y, board, words, nextIndex, status)) {
        return true;
      }
      if (y + 1 < board[x].length && find(x, y + 1, board, words, nextIndex, status)) {
        return true;
      }
      if (y - 1 >= 0 && find(x, y - 1, board, words, nextIndex, status)) {
        return true;
      }
      status[x][y] = false;
    }
    return false;
  }
}
