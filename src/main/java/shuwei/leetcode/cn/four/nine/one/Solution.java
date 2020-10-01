package shuwei.leetcode.cn.four.nine.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
  // 从前往后遍历，遇到比自己大的就一顿拼，使用Set去重
  // 25ms 13%
  public List<List<Integer>> findSubsequences(int[] nums) {
    Set<List<Integer>> res = new HashSet<>();
    Map<Integer, Set<List<Integer>>> cache = new HashMap<>();
    for (int i = nums.length - 2; i >= 0 ; i--) {
      Set<List<Integer>> set = new HashSet<>();
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] >= nums[i]) {
          set.add(Arrays.asList(nums[i], nums[j]));
          set.addAll(head(nums[i], cache.get(j)));
        }
      }
      cache.put(i, set);
      res.addAll(set);
    }
    List<List<Integer>> ans = new ArrayList<>();
    ans.addAll(res);
    return ans;
  }

  private Set<List<Integer>> head(int newEle, Set<List<Integer>> data) {
    Set<List<Integer>> tmp = new HashSet<>();
    if (data == null) {
      return tmp;
    }
    for (List<Integer> ele : data) {
      List<Integer> list = new ArrayList<>();
      list.add(newEle);
      list.addAll(ele);
      tmp.add(list);
    }
    return tmp;
  }

  /**
   * 这个比较慢
   * 找到每个数右边比自己大的数的个数，和去重以后的个数 例如 2 1 5 8 9 3 4 4右边比自己大的数为0，4对结果的贡献为0 3右边比自己大的数1个，对结果的贡献为1 9贡献为0
   * 8贡献为1 5右边比5大的数值为2个，分别8和9，8又是1，则5的贡献是2+1=3 1右边比自己大的数为5个，分别是5 8 9 3 4，其中贡献分别是3 + 1 + 0 + 1 +
   * 0=5,则1个贡献是5+5=10 2跟1相同也是10
   *
   * 4 6 7 7 7对应0 7对应1  -> 77 6对应1， + 7对应1 = 2 -> 67 677 4对应2， + 6对应2 + 7对应1 = 5 -> 46 47 467 4677
   * 477 总数是:5+2+1 从右往左找到比自己大的数以及去重后的数即可，需要所有比自己大的数的下标，以及所有比自己大的数的个数(去重)
   * 使用Set<List<Integer>>可以去重
   */
  public List<List<Integer>> findSubsequences2(int[] nums) {
    // 采用比较简单的从右往左遍历，把比这个数大的数放在一个list中
    data = new ArrayList[nums.length];
    cache = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      data[i] = new ArrayList<>();
    }
    for (int i = nums.length - 1; i > 0; i--) {
      for (int j = i - 1; j >= 0; j--) {
        if (nums[i] >= nums[j]) {
          data[j].add(i);
        }
      }
    }
    Set<List<Integer>> set = new HashSet<>();
    for (int i = nums.length - 2; i >= 0; i--) {
      set.addAll(calCount(nums, i));
    }
    // 从后往前算结果
    List<List<Integer>> ans = new ArrayList<>();
    ans.addAll(set);
    return ans;
  }

  private List<Integer>[] data;
  private Map<Integer, Set<List<Integer>>> cache;

  private Set<List<Integer>> calCount(int[] nums, int i) {
    Set<List<Integer>> res = new HashSet<>();
    List<Integer> src = data[i];
    for (Integer ele : src) {
      // ele 是当前索引后面比当前索引数值大的数
      res.add(Arrays.asList(nums[i], nums[ele]));
      Set<List<Integer>> values = cache.get(ele);
      if (values != null) {
        for (List<Integer> lls : values) {
          List<Integer> thisList = new ArrayList<>();
          thisList.add(nums[i]);
          thisList.addAll(lls);
          res.add(thisList);
        }
      }
    }
    cache.put(i, res);
    return res;
  }
}
