package shuwei.leetcode.cn.mst.zero.nine;

import org.junit.Assert;
import org.junit.Test;

public class CQueueTest {
  @Test
  public void test() {
    CQueue tObj = new CQueue();
    tObj.appendTail(3);
    Assert.assertEquals(3, tObj.deleteHead());
    Assert.assertEquals(-1, tObj.deleteHead());
    Assert.assertEquals(-1, tObj.deleteHead());
    tObj.appendTail(5);
    tObj.appendTail(2);
    Assert.assertEquals(5, tObj.deleteHead());
    Assert.assertEquals(2, tObj.deleteHead());
  }
}
