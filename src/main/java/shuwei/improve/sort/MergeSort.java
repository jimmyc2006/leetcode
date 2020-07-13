package shuwei.improve.sort;

public class MergeSort {

  public int[] mergeSort(int[] arr) {
    return merge(arr, 0, arr.length - 1);
  }

  // 2, 4, 6, 8
  private int[] merge(int[] arr, int start, int end) {
    if(start == end) {
      return new int[]{arr[start]};
    }
    int mid = (start + end) / 2;
    int[]  left = merge(arr, start, mid);
    int[] right = merge(arr, mid + 1, end);
    int[] res = new int[left.length + right.length];
    for (int index = 0, i = 0, j = 0; i < left.length || j < right.length;) {
      while(i < left.length  && (j == right.length || left[i] <= right[j])) {
        res[index++] = left[i];
        i++;
      }
      while (j < right.length && (i == left.length || right[j] < left[i] )) {
        res[index++] = right[j];
        j++;
      }
    }
    return res;
  }
}
