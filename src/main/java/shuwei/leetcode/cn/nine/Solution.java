package shuwei.leetcode.cn.nine;
/** 
* @author shuwei 
* @version 创建时间：2020年4月22日 下午7:37:30 
* 类说明 
*/
public class Solution {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    } else if(x == 0) {
      return true;
    }
    int reverse = 0;
    int tmp = x;
    while (tmp > 0) {
      reverse = 10 * reverse + (tmp % 10);
      tmp = tmp / 10;
    }
    return reverse == x;
  }

  public boolean isPalindrome1(int x) {
    if (x < 0) {
      return false;
    } else if (x == 0) {
      return true;
    }
    int j = x;
    int y = 0;
    while (j > 0) {
      y = y * 10 + j % 10;
      j = j / 10;
    }
    return y == x;
  }
}
