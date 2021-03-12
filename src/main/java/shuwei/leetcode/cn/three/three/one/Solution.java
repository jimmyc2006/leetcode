package shuwei.leetcode.cn.three.three.one;

public class Solution {

  /**
   * 初始数值为1，遇到一个数字就+1，遇到一个#就减1
   * 如果0的时候正好是字符串的最后一个字符，则是二叉树
   * @param preorder
   * @return
   */
  public boolean isValidSerialization(String preorder) {
    int nums = 1;
    boolean isNewNum = true;
    for (int i = 0; i < preorder.length(); i++) {
      if (preorder.charAt(i) == ',') {
        isNewNum = true;
        continue;
      }
      if (preorder.charAt(i) == '#') {
        nums--;
        if (nums == 0) {
          return i == preorder.length() - 1;
        }
      } else {
        if (isNewNum) {
          nums++;
          isNewNum = false;
        }
      }
    }
    return nums == 0;
  }
}
