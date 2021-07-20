package shuwei.leetcode.cn.five.six.eight.nine;

import java.util.List;

public class Solution {
  public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
    int ans = 0;
    int index = - 1;
    if (ruleKey.equals("type")) {
      index = 0;
    } else if (ruleKey.equals("color")) {
      index = 1;
    } else {
      index = 2;
    }
    for (List<String> item : items) {
      if (item.get(index).equals(ruleValue)) {
        ans++;
      }
    }
    return ans;
  }

}
