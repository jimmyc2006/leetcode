package shuwei.leetcode.cn.one.one.seven.eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  /**
   * 这个题是处理字符串去重后的数据 因为只涉及到有没有，并不涉及到数量问题 所以采用二进制压缩状态 int 有32位，足够放26个字母
   * 由于要寻找，puzzles包含的，且被包含对象需要包含puzzles的第一个字符，采用将words入字典，然后每个puzzles直接匹配所有带它第一个字符的子集
   */
  public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
    Map<Integer, Integer> data = new HashMap<>();
    for (String word : words) {
      int key = change(word, 0);
      if (Integer.bitCount(key) <= 7) {
        Integer val = data.get(key);
        if (val == null) {
          data.put(key, 1);
        } else {
          data.put(key, val + 1);
        }
      }
    }
    List<Integer> ans = new ArrayList<>();
    // 查找
    for (String puzzle : puzzles) {
      int currCount = 0;
      int ci = change(puzzle, 1);
      int mask = ci;
      while (true) {
        currCount += getCount(data, mask | (1 << (puzzle.charAt(0) - 'a')));
        mask = (mask - 1) & ci;
        if (mask == ci) {
          break;
        }
      }
      ans.add(currCount);
    }
    return ans;
  }

  private int getCount(Map<Integer, Integer> data, Integer key) {
    Integer res = data.get(key);
    if (res != null) {
      return res;
    } else {
      return 0;
    }
  }

  private int change(String str, int start) {
    int result = 0;
    for (int i = start; i < str.length(); i++) {
      result = result | (1 << str.charAt(i) - 'a');
    }
    return result;
  }
}
