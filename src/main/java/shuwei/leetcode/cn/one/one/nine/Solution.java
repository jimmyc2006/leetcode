package shuwei.leetcode.cn.one.one.nine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public List<Integer> getRow(int rowIndex) {
    if (rowIndex == 0) {
      return Arrays.asList(new Integer[]{1});
    }
    if (rowIndex == 1) {
      return Arrays.asList(new Integer[]{1, 1});
    }
    int[] res = new int[rowIndex + 1];
    res[0] = 1;
    res[1] = 1;
    for (int i = 2; i <= rowIndex; i++) {
      cal(res, i);
    }
    List<Integer> ans = new ArrayList<>();
    for (int re : res) {
      ans.add(re);
    }
    return ans;
  }

  private void cal(int[] data, int k) {
    int left = 0;
    int right = k;
    data[right] = 1;
    left++;
    right--;
    int tmp1 = data[left - 1];
    int tmp2;
    while (left <= right) {
      tmp2 = data[left];
      data[left] = tmp1 + data[left];
      data[right] = data[left];
      tmp1 = tmp2;
      left++;
      right--;
    }
  }

}
