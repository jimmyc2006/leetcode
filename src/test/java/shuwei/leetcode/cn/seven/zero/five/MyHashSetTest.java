package shuwei.leetcode.cn.seven.zero.five;

import org.junit.Assert;
import org.junit.Test;

public class MyHashSetTest {

  @Test
  public void test() {
    MyHashSet myHashSet = new MyHashSet();
    myHashSet.add(1);
    myHashSet.add(2);
    Assert.assertTrue(myHashSet.contains(1));
    Assert.assertFalse(myHashSet.contains(3));
    myHashSet.add(2);
    Assert.assertTrue(myHashSet.contains(2));
    myHashSet.remove(2);
    Assert.assertFalse(myHashSet.contains(2));
  }
}
