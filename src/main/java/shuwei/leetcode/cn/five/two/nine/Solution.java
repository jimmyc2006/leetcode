package shuwei.leetcode.cn.five.two.nine;

public class Solution {
  /**
   * 采用dfs
   * 如果是E就计算，如果判断该方块是数字，就不继续扩展
   * 要将被点的位置和扩展的分开
   *
   */
  public char[][] updateBoard(char[][] board, int[] click) {
    if (board.length < 1 || board[0].length < 1) {
      return board;
    }
    if (board[click[0]][click[1]] == 'M') {
      board[click[0]][click[1]] = 'X';
    } else {
      spread(board, click[0], click[1]);
    }
    return board;
  }

  private void spread(char[][] board, int x, int y) {
    if (board[x][y] == 'E') {
      board[x][y] = calculate(board, x, y);
      if (board[x][y] != 'B') {
        return;
      }
      if (x - 1 >= 0) {
        spread(board, x - 1, y);
        if (y - 1 >= 0) {
          spread(board, x - 1, y - 1);
        }
        if ( y + 1 < board[x].length) {
          spread(board, x - 1, y + 1);
        }
      }
      if (y - 1 >= 0) {
        spread(board, x, y - 1);
      }
      if (y + 1 < board[x].length) {
        spread(board, x, y + 1);
      }
      if (x + 1 < board.length) {
        spread(board, x + 1, y);
        if (y - 1 >= 0) {
          spread(board, x + 1, y - 1);
        }
        if (y + 1 < board[x].length) {
          spread(board, x + 1, y + 1);
        }
      }
    }
  }

  private char calculate(char[][] board, int x, int y) {
    int xMax = board.length;
    int yMax = board[0].length;
    int leiCount = 0;
    // 上面3个
    if (x - 1 >= 0) {
      leiCount += this.count(board, x - 1, y);
    }
    // 中间，因为自己不是雷，所以多判断一个也没影响
    leiCount += this.count(board, x, y);
    // 下面3ge
    if (x + 1 < xMax) {
      leiCount += this.count(board, x + 1, y);
    }
    if (leiCount > 0) {
      return (char)('0' + leiCount);
    } else {
      return 'B';
    }

  }

  private int count(char[][] board, int x, int y) {
    int ans = 0;
    if (y - 1 >= 0 && board[x][ y - 1] == 'M') {
      ans++;
    }
    if (board[x][y] == 'M') {
      ans++;
    }
    if (y + 1 < board[x].length && board[x][y + 1] == 'M') {
      ans++;
    }
    return ans;
  }
}
