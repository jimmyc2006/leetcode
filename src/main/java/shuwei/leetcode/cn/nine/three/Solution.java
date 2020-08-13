package shuwei.leetcode.cn.nine.three;


import java.util.ArrayList;
import java.util.List;

public class Solution {

  // 先使用遍历的方式
  // 这种方式可能会有一些重复计算
  public List<String> restoreIpAddresses(String s) {
    List<String> ans = new ArrayList<>();
    gen(s, 0, 0, ans, new String[4]);
    return ans;
  }


  private void gen(String content, int index, int level, List<String> ans, String[] tmp) {
    if ((4 - level) * 3 < content.length() - index) {
      return;
    }
    if (level == 4) {
      if (index == content.length()) {
        ans.add(tmp[0] + "." + tmp[1] + "." + tmp[2] + "." + tmp[3]);
        return;
      } else {
        return;
      }
    }
    for (int j = 1; j <= 3 && index + j <= content.length(); j++) {
      int thisSign = Integer.parseInt(content.substring(index, index + j));
      if (thisSign <= 255) {
        tmp[level] = Integer.toString(thisSign);
        gen(content, index + j, level + 1, ans, tmp);
      }
      if(content.charAt(index) == '0') {
        break;
      }
    }
  }

  // dp算法：
  // 每增加一个，如果该位不是最后一位，则不用算出现4组的情况
  // 也就是说除了最后一位，每位都可能出现dp[i][1],dp[i][2],dp[i][3]表示dp[i]出现的组合,但是二维的值又是一个list
  // 每增加一位，就多一种，相对于前面最大的分组dp[i - 1] + 最后这1位得出
  // 如果该位置能与倒数第二个位置组合，那么就会通过dp[i-2] + 最后这2位得出
  // 如果该位置能与倒数第三个位置组合，那么就会通过dp[i - 3] + 最后这3位得出
//  public List<String> restoreIpAddresses(String s) {
//    int length = s.length();
//    char[] content = s.toCharArray();
//    List[][] dp = new ArrayList[length][4];
//    dp[0][0] = new ArrayList<>();
//    dp[0][0].add(content[0]);
//    for (int i = 1; i < length; i++) {
//      dp[i - 1]
//    }
//  }

}
