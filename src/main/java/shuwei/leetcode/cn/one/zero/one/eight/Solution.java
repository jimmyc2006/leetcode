package shuwei.leetcode.cn.one.zero.one.eight;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  /**
   * 从前往后计算,体重A的长度可能达到3000，所以计算的时候，需要注意溢出问题
   * @param A
   * @return
   */
  public List<Boolean> prefixesDivBy5(int[] A) {
    int currSum = 0;
    List<Boolean> ans = new ArrayList<>();
    for(int ele : A) {
      currSum = currSum * 2 + ele;
      if (currSum >= 5) {
        currSum = currSum - 5;
      }
      if (currSum == 0 ) {
        ans.add(true);
      } else {
        ans.add(false);
      }
    }
    return ans;
  }

}
