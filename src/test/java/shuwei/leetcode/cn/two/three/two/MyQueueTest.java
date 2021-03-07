package shuwei.leetcode.cn.two.three.two;

import org.junit.Assert;
import org.junit.Test;

public class MyQueueTest {

  @Test
  public void test() {
    MyQueue queue = new MyQueue();
    queue.push(1);
    queue.push(2);
    Assert.assertEquals(1, queue.peek());
    Assert.assertEquals(1, queue.pop());
    Assert.assertEquals(false, queue.empty());
    Assert.assertEquals(2, queue.pop());
    Assert.assertEquals(true, queue.empty());
  }
  @Test
  public void test2() {
    MyQueue queue = new MyQueue();
    Assert.assertEquals(true, queue.empty());
    queue.push(1);
    Assert.assertEquals(1, queue.pop());
    Assert.assertEquals(true, queue.empty());
  }
}
