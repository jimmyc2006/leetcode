package shuwei.improve.accu.sort;

public class ShellSort {

  public static void sort(int[] a) {
    int N = a.length;
    int h = 1;
    while (h < N / 3) {
      h = 3 * h + 1; // 1,4,13,40,121,364..
    }
    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h; j -= h) {
          if (a[j] < a[j - h]) {
            swap(a, j, j - h);
          }
        }
      }
      h = h / 3;
    }
  }

  private static void swap(int[] arr, int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }

}
