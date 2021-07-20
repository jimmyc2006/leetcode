package shuwei.improve.accu.sort;

import org.junit.Test;

import java.util.Arrays;

public class ShellSortTest {

  @Test
  public void test() {
    int[] arr = {1,4,3,2,9,6};
    ShellSort.sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
