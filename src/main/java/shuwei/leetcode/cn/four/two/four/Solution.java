package shuwei.leetcode.cn.four.two.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
  public int characterReplacement(String s, int k) {
    int ans = 0;
    int length = s.length();
    if (length <= 1) {
      return s.length();
    }
    if (k == 0) {
      int curr = 1;
      char last = s.charAt(0);
      for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == last) {
          curr++;
        } else {
          ans = Math.max(ans, curr);
          curr = 1;
          last = s.charAt(i);
        }
      }
      return Math.max(ans, curr);
    }
    List<Integer>[] indexs = new List[26];
    for (int i = 0; i < 26; i++) {
      indexs[i] = new ArrayList<>();
    }
    for (int i = 1; i < s.length(); i++) {
      indexs[s.charAt(i) - 'A'].add(i);
    }
    Arrays.sort(indexs, Comparator.comparingInt(l -> l.size()));
    for (int i = 25; i >= 0; i--) {
      if (indexs[i].size() == 0 || indexs[i].size() + k <= ans) {
        break;
      }
      ans = Math.max(ans, cal(indexs[i], k, length));
    }
    return ans;
  }

  private int cal(List<Integer> indexs, int k, int length) {
    if (indexs.size() <= k || indexs.size() <= 1) {
      return indexs.size() + k;
    }
    int size = indexs.size();
    int ans = 0;
    int result = 1;
    int startIndex = 0;
    int curr;
    int remain = k;
    for (int i = 1; i < size; i++) {
      curr = indexs.get(i - 1);
      while (indexs.get(i) != curr + 1) {
        if (k == 0) {
          ans = Math.max(ans, result);
          startIndex++;
          if (startIndex < i) {
            result = 1;
            k = remain;
            continue;
          }
          int diff = indexs.get(startIndex) - indexs.get(startIndex - 1);
          while (startIndex < size && diff == 1) {
            result--;
            startIndex++;
            diff = indexs.get(startIndex) - indexs.get(startIndex - 1);
          }
          result -= diff;
          k += diff - 1;
        } else {
          k--;
          curr++;
          result++;
        }
      }
      result++;
    }
    if (k > 0) {
      int empty = indexs.get(0) + length - indexs.get(indexs.size() - 1) - 1;
      if ( empty >= k) {
        return Math.max(ans, result + k);
      } else {
        return Math.max(ans, result + empty);
      }
    } else {
      return Math.max(ans, result);
    }
  }
}
