package shuwei.shuwei.leetcode.cn.six.five.seven;

public class Solution {

  public boolean judgeCircle(String moves) {
    int x = 0, y = 0;
    char[] contents = moves.toCharArray();
    for (int i = 0; i < contents.length; i++) {
      if (contents[i] == 'R') {
        x++;
      } else if (contents[i] == 'L') {
        x--;
      } else if (contents[i] == 'U') {
        y++;
      } else if (contents[i] == 'D') {
        y--;
      }
    }
    return x == 0 && y == 0;
  }
}
