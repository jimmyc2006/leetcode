package shuwei.leetcode.cn.one.zero.zero.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public List<String> commonChars(String[] A) {
    int[] last = new int[27];
    int[] curr = new int[27];
    char[] chars1 = A[0].toCharArray();
    for (char ele : chars1) {
      last[ele - 'a']++;
    }
    if (A.length == 1) {
      return Arrays.asList(A[0].split(""));
    }
    for (int i = 1; i < A.length; i++) {
      char[] cs = A[i].toCharArray();
      for (int j = 0; j < cs.length; j++) {
        int index = cs[j] - 'a';
        if (last[index] > curr[index]) {
          curr[index]++;
        }
      }
      int[] tmp = last;
      last = curr;
      curr = tmp;
      Arrays.fill(tmp, 0);
    }
    List<String> ans = new ArrayList<>();
    for (char ele : chars1) {
      if (last[ele - 'a'] > 0) {
        last[ele - 'a']--;
        ans.add(String.valueOf(ele));
      }
    }
    return ans;
  }

}
