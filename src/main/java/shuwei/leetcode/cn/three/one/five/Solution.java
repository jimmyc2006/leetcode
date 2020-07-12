package shuwei.leetcode.cn.three.one.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Solution {

  // 看了官方的归并+索引数组算法, 没有看代码
  public List<Integer> countSmaller(int[] nums) {
    if(nums.length < 1) {
      return new ArrayList<>();
    }
    indexs = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      indexs[i] = i;
    }
    ans = new int[nums.length];
    this.nums = nums;
    mergeSort(0, nums.length - 1);
    List<Integer> result = new ArrayList<>(nums.length);
    for (int ele : ans) {
      result.add(ele);
    }
    return result;
  }

  private int[] nums;
  private int[] indexs;
  private int[] ans;

  private int[] mergeSort(int start, int end) {
    if (start == end) {
      return new int[]{indexs[start]};
    }
    int mid = (start + end) / 2;
    int[] left  = mergeSort(start, mid);
    int[] right = mergeSort(mid + 1, end);
    int[] tmpArr = new int[left.length + right.length];
    int index = 0, i = 0, j = 0;
    while(i < left.length || j < right.length) {
      while(i < left.length && (j == right.length || nums[left[i]] <= nums[right[j]])) {
        ans[left[i]] += j;
        tmpArr[index++] = left[i];
        i++;
      }
      while(j < right.length && (i == left.length || nums[right[j]] < nums[left[i]])) {
        tmpArr[index++] = right[j];
        j++;
      }
    }
    return tmpArr;
  }

  // 能ac，
  public List<Integer> countSmaller3(int[] nums) {
    if(nums.length < 1) {
      return new ArrayList<>();
    }
    int[] sortedArr = new int[nums.length];
    Integer[] ans = new Integer[nums.length];
    int size = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      ans[i] = insert(sortedArr, size++, nums[i]);
    }
    return Arrays.asList(ans);
  }

  // 26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41
  private int insert(int[] arr, int length, int insertValue) {
    int index = search(arr, 0, length, insertValue);
    // 移动
    for (int i = length - 1; i >= index ; i--) {
      arr[i + 1] = arr[i];
    }
    arr[index] = insertValue;
    return index;
  }
  private int search(int[] arr, int start, int end, int val) {
    if (start >= end) {
      return start;
    }
    int mid = (start + end) / 2;
    if (arr[mid] < val) {
      return search(arr, mid + 1, end, val);
    } else {
      return search(arr, start, mid, val);
    }
  }

  // 还是超时
  public List<Integer> countSmaller2(int[] nums) {
    TreeMap<Integer, int[]> map = new TreeMap<>();
    Integer[] ans = new Integer[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      int[] val = map.get(nums[i]);
      if (val == null) {
        // 将当前节点的值设置为比它小的值+n
        Map.Entry<Integer, int[]> integerEntry = map.floorEntry(nums[i]);
        if (integerEntry == null) {
          map.put(nums[i], new int[]{0, 1});
        } else {
          int[] aa = integerEntry.getValue();
          map.put(nums[i], new int[]{aa[0] + aa[1], 1});
        }
      } else {
        val[1]++;
      }
      // 将所有比它大key的值都+1
      Map.Entry<Integer, int[]> higherEntry = map.higherEntry(nums[i]);
      while(higherEntry != null) {
        higherEntry.getValue()[0]++;
        higherEntry = map.higherEntry(higherEntry.getKey());
      }
      ans[i] = map.get(nums[i])[0];
    }
    return Arrays.asList(ans);
  }

  //  暴力，超时
  public List<Integer> countSmaller1(int[] nums) {
    int[] ans = new int[nums.length];
    for (int i = nums.length - 1; i > 0; i--) {
      for (int j = i - 1; j >= 0; j--) {
        if (nums[j] > nums[i]) {
          ans[j]++;
        }
      }
    }
    return Arrays.stream(ans).boxed().collect(Collectors.toList());
  }

}
