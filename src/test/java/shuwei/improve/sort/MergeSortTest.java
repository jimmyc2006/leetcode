package shuwei.improve.sort;

import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {
  @Test
  public void test() {
    MergeSort ms = new MergeSort();
    System.out.print(Arrays.toString(ms.mergeSort(new int[]{2, 4, 6, 8})));
  }
}
