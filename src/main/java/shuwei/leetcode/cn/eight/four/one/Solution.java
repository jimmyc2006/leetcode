package shuwei.leetcode.cn.eight.four.one;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  /**
   * 用一个数组表示每个门打开情况，false是没打开，true已经进去过
   * 执行用时：
   * 2 ms
   * , 在所有 Java 提交中击败了
   * 76.33%
   * 的用户
   * @param rooms
   * @return
   */
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    if (rooms.size() <= 1) {
      return true;
    }
    int count = rooms.size();
    boolean[] status = new boolean[count];
    List<List<Integer>> hasKeys = new ArrayList<>(10);
    hasKeys.add(rooms.get(0));
    int openCount = 1;
    status[0] = true;
    while (hasKeys.size() > 0) {
      List<Integer> keys = hasKeys.remove(hasKeys.size() - 1);
      for (Integer key : keys) {
        if (!status[key]) {
          status[key] = true;
          openCount++;
          if (openCount == count) {
            return true;
          }
          hasKeys.add(rooms.get(key));
        }
      }
    }
    return false;
  }

}
