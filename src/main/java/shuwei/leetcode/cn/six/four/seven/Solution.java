package shuwei.leetcode.cn.six.four.seven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  /**
   * 采用从前到后遍历算法，用一个带记忆的Map来记录字符串曾经出现过的位置索引
   * 用一个二维数组表示曾经出现过的回文字串
   * 遍历到每一个字符的时候，当前一个字符必定是回文
   * 剩下的如果存在子回文串，那么必定是和它一样的字符，(index)为左边界，然后查看index + 1 到当前i - 1是否是回文即可
   * 如果两个所以相同，必定是回文
   *
   */
  public int countSubstrings(String s) {
    if (s == null || s.length() < 1) {
      return 0;
    }
    int ans = 0;
    Map<Character, List<Integer>>  indexs = new HashMap<>();
    boolean[][] isBack = new boolean[s.length()][s.length()];
    char[] content = s.toCharArray();
    for (int i = 0; i < content.length; i++) {
      ans++;
      List<Integer> beforeIndexs = indexs.get(content[i]);
      if (beforeIndexs == null) {
        beforeIndexs = new ArrayList<>();
        indexs.put(content[i], beforeIndexs);
      } else {
        // 获取索引，并且判断是否是回文
        for (int j = 0; j < beforeIndexs.size(); j++) {
          int index = beforeIndexs.get(j);
          if (index + 1 >= i - 1) {
            ans++;
            isBack[index][i] = true;
          } else if(isBack[index + 1][i - 1]) {
            ans++;
            isBack[index][i] = true;
          }
        }
      }
      beforeIndexs.add(i);
    }
    return ans;
  }
}
