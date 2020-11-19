package shuwei.improve.accu.sort;

import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    int[] testData = {3, 5, 7, 2, 1, 9, 8, 4, 6};
    quickSort(testData, 0, testData.length - 1);
    System.out.println(Arrays.toString(testData));
  }


  public static void quickSort(int[] arr, int start, int end) {
    if (start >= end) {
      return;
    }
    int mid = arr[start];
    int left = start;
    int right = end;
    while (left < right) {
      while (arr[left] <= mid && left < right) {
        left++;
      }
      while (left < right && arr[right] > mid) {
        right--;
      }
      if (left != right) {
        swap(arr, left, right);
        right--;
      }
    }
    if (arr[left] < arr[start]) {
      swap(arr, start, left);
    }
    quickSort(arr, start, left - 1);
    quickSort(arr, left + 1, end);
  }

  private static void swap(int[] arr, int src, int dst) {
    int tmp = arr[src];
    arr[src] = arr[dst];
    arr[dst] = tmp;
  }
}
