package shuwei.leetcode.cn.three.eight.one;

import org.junit.Assert;
import org.junit.Test;

public class RandomizedCollectionTest {

  @Test
  public void test() {
    RandomizedCollection s = new  RandomizedCollection();
    Assert.assertTrue(s.insert(1));
    Assert.assertTrue(s.insert(2));
    Assert.assertFalse(s.insert(1));
    int[] res = new int[3];
    res[s.getRandom()]++;
    res[s.getRandom()]++;
    res[s.getRandom()]++;
    Assert.assertEquals(2, res[1]);
    Assert.assertEquals(1, res[2]);
    res = new int[3];
    res[s.getRandom()]++;
    res[s.getRandom()]++;
    res[s.getRandom()]++;
    Assert.assertEquals(2, res[1]);
    Assert.assertEquals(1, res[2]);
    Assert.assertTrue(s.remove(1));
    res = new int[3];
    res[s.getRandom()]++;
    res[s.getRandom()]++;
    Assert.assertEquals(1, res[1]);
    Assert.assertEquals(1, res[2]);
  }

  @Test
  public void test2() {
    RandomizedCollection s = new  RandomizedCollection();
    Assert.assertTrue(s.insert(1));
    Assert.assertFalse(s.insert(1));
    Assert.assertTrue(s.insert(2));
    Assert.assertEquals(1, s.getRandom());
    Assert.assertTrue(s.remove(1));
    Assert.assertEquals(2, s.getRandom());
  }



  @Test
  public void test3() {
    RandomizedCollection s = new  RandomizedCollection();
    Assert.assertTrue(s.insert(1));
    Assert.assertTrue(s.insert(10));
    Assert.assertFalse(s.insert(10));
    Assert.assertTrue(s.insert(100));
    Assert.assertEquals(1, s.getRandom());
    Assert.assertEquals(10, s.getRandom());
    Assert.assertEquals(10, s.getRandom());
    Assert.assertEquals(100, s.getRandom());
    Assert.assertEquals(1, s.getRandom());
    Assert.assertEquals(10, s.getRandom());
    Assert.assertEquals(10, s.getRandom());
    Assert.assertEquals(100, s.getRandom());
  }
}
