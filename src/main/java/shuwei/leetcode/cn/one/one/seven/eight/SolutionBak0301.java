package shuwei.leetcode.cn.one.one.seven.eight;

import java.util.ArrayList;
import java.util.List;

public class SolutionBak0301 {

  /**
   * 这都超时。。
   * @param words
   * @param puzzles
   * @return
   */
  public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
    List<String>[] data = new List[26];
    for (int i = 0; i < data.length; i++) {
      data[i] = new ArrayList<>();
    }
    for (String word : words) {
      deal(data, word);
    }
    List<Integer> ans = new ArrayList<>();
    for (String puzzle : puzzles) {
      ans.add(cal(data, puzzle));
    }
    return ans;
  }

  private StringBuilder sb = new StringBuilder();
  private int[] counts = new int[26];

  private void deal(List<String>[] data, String str) {
    sb.delete(0, sb.length());
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (counts[ch - 'a']++ == 0) {
        sb.append(str.charAt(i));
      }
    }
    String st = sb.toString();
    for (int i = 0; i < sb.length(); i++) {
      int index = sb.charAt(i) - 'a';
      counts[index] = 0;
      data[index].add(st);
    }
  }

  private int cal(List<String>[] data, String word) {
    for (int i = 0; i < word.length(); i++) {
      counts[word.charAt(i) - 'a']++;
    }
    int ans = 0;
    for (String s : data[word.charAt(0) - 'a']) {
      int j = 0;
      for (j = 0; j < s.length(); j++) {
        if (counts[s.charAt(j) - 'a'] == 0) {
          break;
        }
      }
      if (j == s.length()) {
        ans++;
      }
    }
    for (int i = 0; i < word.length(); i++) {
      counts[word.charAt(i) - 'a'] = 0;
    }
    return ans;
  }
}
