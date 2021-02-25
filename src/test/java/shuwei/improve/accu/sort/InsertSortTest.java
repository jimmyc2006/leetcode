package shuwei.improve.accu.sort;

import org.junit.Test;

import java.util.Arrays;

public class InsertSortTest {

  @Test
  public void test() {
    int[] arr = {1,4,3,2,9,6};
    InsertSort.sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
