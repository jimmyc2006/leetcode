package shuwei.leetcode.cn.mst.five.one;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author shuwei
 * @version 创建时间：2020年4月24日 下午5:57:28 类说明
 */
public class Solution {
  // 自己借鉴归并排序之后写的
  public int reversePairs(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return 0;
    }
    return rev(nums, 0, nums.length, new int[nums.length]);
  }
  
  public int rev(int[] datas, int startIndex, int endIndex, int[] tmpResult) {
    int middle = (endIndex - startIndex) / 2;
    if (endIndex - startIndex <= 1) {
      tmpResult[0] = datas[startIndex];
      return 0;
    }
    int result = 0;
    int[] leftArr = new int[middle];
    int[] rightArr = new int[endIndex - middle - startIndex];
    result += rev(datas, startIndex, startIndex + middle, leftArr);
    result += rev(datas, startIndex + middle, endIndex, rightArr);
    int index = startIndex;
    int k = 0;
    for (int i = 0, j = 0; i < middle || j < rightArr.length;) {
      if (leftArr[i] > rightArr[j]) {
        datas[index++] = rightArr[j];
        tmpResult[k++] = rightArr[j];
        j++;
        result += middle - i;
      } else {
        datas[index++] = leftArr[i];
        tmpResult[k++] = leftArr[i];
        i++;
      }
      while (i == middle && j < rightArr.length) {
        datas[index++] = rightArr[j];
        tmpResult[k++] = rightArr[j];
        j++;
      }
      while (j == rightArr.length && i < middle) {
        datas[index++] = leftArr[i];
        tmpResult[k++] = leftArr[i];
        i++;
      }
    }
    return result;
  }


  // 这个性能无法通过
  public int reversePairs2(int[] nums) {
    TreeMap<Integer, Integer> data = new TreeMap<>();
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      Map.Entry<Integer, Integer> entry = data.higherEntry(nums[i]);
      while (entry != null) {
        sum += entry.getValue();
        entry = data.higherEntry(entry.getKey());
      }
      // 检查是否有重复数据
      Integer times = data.get(nums[i]);
      if (times != null) {
        data.put(nums[i], times + 1);
      } else {
        data.put(nums[i], 1);
      }
    }
    return sum;
  }
}
