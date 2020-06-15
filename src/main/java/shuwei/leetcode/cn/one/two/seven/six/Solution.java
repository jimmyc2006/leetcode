package shuwei.leetcode.cn.one.two.seven.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
    int bigNum = 0, smallNum = 0, curTomato = 0, curSlice = 0;
    while (curSlice < cheeseSlices) {
      bigNum++;
      curTomato += 4;
      curSlice += 1;
    }
    if (curTomato == tomatoSlices && curSlice == cheeseSlices) {
      return Arrays.asList(bigNum, 0);
    }
    while(curTomato > tomatoSlices && bigNum > 0) {
      bigNum--;
      smallNum++;
      curTomato = curTomato - 2;
    }
    if (curTomato == tomatoSlices && curSlice == cheeseSlices) {
      return Arrays.asList(bigNum, smallNum);
    } else {
      return new ArrayList<>();
    }
  }
}
