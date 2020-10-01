package shuwei.leetcode.cn.three.seven;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  /**
   * 先根据行扫描，然后计算每个空位可能的数值 再按照列扫描，然后计算每个空位可能的数值 再根据方框扫描，计算每个空位可能的数值
   */
  public void solveSudoku(char[][] board) {
    data = new Set[board.length][board[0].length];
    // 先初始化
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == '.') {
          data[i][j] = allNum();
        }
      }
    }
    this.hengxiangAll(board);
    this.zongxiangAll(board);
    this.fangkuangAll(board);
    this.calculate(board);
  }

  private Set<Character>[][] data;

  private void calculate(char[][] board) {
    int[] min = this.findMinGuess(board);
    guess(min[0], min[1], board);
  }

  // 开始猜测，如果有冲突就返回false，否则返回true
  private boolean guess(int x, int y, char[][] board) {
    for (Character c : data[x][y]) {
      if (chongtu(x, y, c, board)) {
        continue;
      }
      // 猜测每一个值以后，需要将相关人员剪掉这个值
      board[x][y] = c;
      int[] minGuess = this.findMinGuess(board);
//      System.out.println(x + ":" + y + "->" + c);
      if (minGuess[0] == -1) {
        return true;
      } else {
        if (guess(minGuess[0], minGuess[1], board)) {
          return true;
        }
      }
    }
    board[x][y] = '.';
    return false;
  }

  private boolean chongtu(int x, int y, Character c, char[][] board) {
    for (int i = 0; i < 9; i++) {
      if (board[x][i] == c) {
        return true;
      }
      if (board[i][y] == c) {
        return true;
      }
    }
    for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {
      for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
        if (board[i][j] == c) {
          return true;
        }
      }
    }
    return false;
  }

  private int[] findMinGuess(char[][] board) {
    int min = 10;
    int x = -1, y = -1;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.' && data[i][j].size() < min) {
          min = data[i][j].size();
          x = i;
          y = j;
        }
      }
    }
    return new int[]{x, y};
  }

  private Set<Character> allNum() {
    Set<Character> set = new HashSet<>(9);
    for (char i = '1'; i <= '9'; i++) {
      set.add(i);
    }
    return set;
  }

  private void hengxiangAll(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      hengxiang(i, board);
    }
  }

  private void hengxiang(int i, char[][] board) {
    Set<Character> tmpSet = allNum();
    Set<Character> hads = new HashSet<>();
    for (int j = 0; j < board[i].length; j++) {
      if (board[i][j] != '.') {
        hads.add(board[i][j]);
      }
    }
    for (int j = 0; j < board[i].length; j++) {
      if (data[i][j] != null) {
        data[i][j].removeAll(hads);
      }
      hads.clear();
    }
  }

  private void zongxiangAll(char[][] board) {
    for (int i = 0; i < 9; i++) {
      zongxiang(i, board);
    }
  }

  private void zongxiang(int j, char[][] board) {
    Set<Character> hads = new HashSet<>();
    for (int i = 0; i < 9; i++) {
      if (board[i][j] != '.') {
        hads.add(board[i][j]);
      }
    }
    for (int i = 0; i < board.length; i++) {
      if (data[i][j] != null) {
        data[i][j].removeAll(hads);
      }
      hads.clear();
    }
  }

  private void fangkuangAll(char[][] board) {
    for (int i = 0; i < 9; i = i + 3) {
      for (int j = 0; j < 9; j = j + 3) {
        fangkuang(i, j, board);
      }
    }
  }

  private void fangkuang(int x, int y, char[][] board) {
    Set<Character> hads = new HashSet<>();
    for (int i = x; i < x + 3; i++) {
      for (int j = y; j < y + 3; j++) {
        if (board[i][j] != '.') {
          hads.add(board[i][j]);
        }
      }
    }
    for (int i = x; i < x + 3; i++) {
      for (int j = y; j < y + 3; j++) {
        if (board[i][j] == '.') {
          data[i][j].removeAll(hads);
        }
      }
    }
  }
}
