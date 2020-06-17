package shuwei.leetcode.cn.three;

import shuwei.leetcode.cn.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  
  public int lengthOfLongestSubstring(String s) {
    if (s == null) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<>();
    char[] charArray = s.toCharArray();
    int startIndex = 0;
    int maxLength = 0;
    for (int i = 0; i < charArray.length; i++) {
      Integer index = map.get(charArray[i]);
      if (index != null && index >= startIndex) {
        maxLength = Math.max(maxLength, i - startIndex);
        startIndex = index + 1;
      }
      map.put(charArray[i], i);
    }
    maxLength = Math.max(maxLength, charArray.length - startIndex);
    return maxLength;
  }
}
