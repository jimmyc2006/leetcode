package shuwei.improve.sfdl.dp.bag;

import org.junit.Assert;
import org.junit.Test;

import shuwei.improve.sfdl.dp.Sample2;

public class Bag2Test {
  @Test
  public void test() {
    Sample2 s2 = new Sample2();
    System.out.println(s2.cutPod(1));
    System.out.println(s2.cutPod(2));
    System.out.println(s2.cutPod(3));
    System.out.println(s2.cutPod(11));
    System.out.println(s2.cutPod(15));
    System.out.println(s2.cutPod(40));
  }
  
  @Test
  public void test2() {
    Sample2 s2 = new Sample2();
    Bag2 bag2 = new Bag2();
    int[] testData = new int[] {1, 2, 3, 11, 15, 40};
    for (int td : testData) {
//      Assert.assertEquals(s2.cutPod(td), bag2.maxValue1(td));
      Assert.assertEquals(s2.cutPod(td), bag2.maxValue2(td));
    }
  }
}
