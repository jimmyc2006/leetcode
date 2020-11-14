package shuwei.leetcode.cn.one.one.two.two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    int[] count = new int[1001];
    for (int ele : arr1) {
      count[ele]++;
    }
    int[] ans = new int[arr1.length];
    int index = 0;
    for (int ele : arr2) {
      for (int i = 0 ; i < count[ele]; i++) {
        ans[index++] = ele;
      }
      count[ele] = 0;
    }
    for (int i = 0; i < count.length; i++) {
      if (count[i] > 0) {
        for (int j = 0; j < count[i]; j++) {
          ans[index++] = i;
        }
      }
    }
    return ans;
  }

  /**
   * 新建一个数组跟arr2长度一样，表示arr2中每个元素的数量
   * 新建一个数组跟arr1长度一样，保存返回的结果
   * 遍历arr1遇到arr2中有的数值就增加其数量
   * @param arr1
   * @param arr2
   * @return
   */
  public int[] relativeSortArray1(int[] arr1, int[] arr2) {
    if (arr1.length < 2) {
      return arr1;
    }
    Map<Integer, Integer> numCount = new HashMap<>();
    for (int ele : arr2) {
      numCount.put(ele, 0);
    }
    int[] ans = new int[arr1.length];
    int index = ans.length - 1;
    for (int i = arr1.length - 1; i >= 0; i--) {
      Integer val = numCount.get(arr1[i]);
      if (val == null) {
        ans[index--] = arr1[i];
      } else {
        numCount.put(arr1[i], val + 1);
      }
    }
    Arrays.sort(ans, index + 1, ans.length);
    index = 0;
    for (int ele : arr2) {
      for (int i = 0; i < numCount.get(ele); i++) {
        ans[index++] = ele;
      }
    }
    return ans;
  }

}
