package shuwei.leetcode.cn.six.zero.five;

public class Solution {

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int max = 0;
    int length = flowerbed.length;
    if (length < 1) {
      return n == 0;
    }
    if (n == 0) {
      return true;
    }
    if (length == 1) {
      return flowerbed[0] == 0 && n == 1;
    }
    if (flowerbed[0] == 0 && flowerbed[1] == 0) {
      flowerbed[0] = 1;
      max++;
    }
    if (flowerbed[length - 1] == 0 && flowerbed[length - 2] == 0) {
      flowerbed[length - 1] = 1;
      max++;
    }
    for (int i = 1; i < length - 1; i++) {
      if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
        flowerbed[i] = 1;
        max++;
      }
    }
    return max >= n;
  }
}
