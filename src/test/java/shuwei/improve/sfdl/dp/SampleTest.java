package shuwei.improve.sfdl.dp;

import org.junit.Test;

/**
 * @author shuwei
 * @version 创建时间：2020年4月17日 下午3:46:43 类说明
 */
public class SampleTest {
  @Test
  public void test1() {
    Sample1 s1 = new Sample1();
    System.out.println(s1.cutPod(1));
    System.out.println(s1.cutPod(2));
    System.out.println(s1.cutPod(3));
    System.out.println(s1.cutPod(10));
    System.out.println(s1.cutPod(20));
  }

  @Test
  public void test2() {
    Sample2 s2 = new Sample2();
    long start = System.currentTimeMillis();
    System.out.println(s2.cutPod(40));
    // System.out.println(s2.cutPod(2));
    // System.out.println(s2.cutPod(3));
    // System.out.println(s2.cutPod(15));
    System.out.println(System.currentTimeMillis() - start);
  }

  @Test
  public void test3() {
    Sample3 s3 = new Sample3();
    s3.cutPod(1);
    s3.cutPod(2);
    s3.cutPod(3);
    s3.cutPod(11);
    s3.cutPod(15);
    s3.cutPod(40);
  }
}
