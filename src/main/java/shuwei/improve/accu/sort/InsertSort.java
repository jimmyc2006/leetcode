package shuwei.improve.accu.sort;

public class InsertSort {

  public static void sort(int[] arr) {
    int length = arr.length;
    for (int i = 1; i < length; i++) {
      for (int j = i; j > 0; j--) {
        if (arr[j] < arr[j - 1]) {
          swap(arr, j, j - 1);
        }
      }
    }
  }

  private static void swap(int[] arr, int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }
}
