package shuwei.leetcode.cn.seven.six.three;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  /**
   * 先记住每个字母最大的索引，然后从第一个字母开始遍历，检查它能达到的最近的距离
   * @param S
   * @return
   */
  public List<Integer> partitionLabels(String S) {
    int[] index = new int[26];
    char[] chars = S.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      index[chars[i] - 'a'] = i;
    }
    List<Integer> ans = new ArrayList<>();
    int startIndex = -1;
    int minIdex = index[chars[0] - 'a'];
    for (int i = 0; i < chars.length; i++) {
      // 只有一个，活着已经到达闭区间
      if (i == minIdex) {
        ans.add(minIdex - startIndex);
        startIndex = i;
        minIdex = 0;
      } else if(minIdex == 0 && index[chars[i] - 'a'] == i) {
        ans.add(1);
        startIndex = i;
      } else if (index[chars[i] - 'a'] > minIdex) {
        minIdex = index[chars[i] - 'a'];
      }
    }
    return ans;
  }

}
