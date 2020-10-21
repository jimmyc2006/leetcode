package shuwei.leetcode.cn.nine.two.five;

public class Solution {

  public boolean isLongPressedName(String name, String typed) {
    if (name == null && typed == null) {
      return true;
    } else if (name == null) {
      return false;
    } else if (typed == null) {
      return false;
    }
    char[] c1 = name.toCharArray();
    char[] c2 = typed.toCharArray();
    int i = 0, j = 0;
    while (j < c2.length) {
      if (i == c1.length) {
        if (i >0 && c2[j] == c1[i - 1]) {
          j++;
        } else {
          return false;
        }
      } else if (c1[i] == c2[j]) {
        i++;
        j++;
      } else if (i > 0 && c2[j] == c1[i - 1]) {
        j++;
      } else {
        return false;
      }
    }
    return i == c1.length;
  }

}
