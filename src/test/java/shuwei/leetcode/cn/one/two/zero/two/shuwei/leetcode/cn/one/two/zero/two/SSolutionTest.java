package shuwei.leetcode.cn.one.two.zero.two.shuwei.leetcode.cn.one.two.zero.two;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SSolutionTest {

  @Test
  public void test() {
    SSolution s = new SSolution();
    Assert.assertEquals("bacd", s.smallestStringWithSwaps("dcab", Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2))));
    Assert.assertEquals("abcd", s.smallestStringWithSwaps("dcab", Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2), Arrays.asList(0, 2))));
    Assert.assertEquals("abc", s.smallestStringWithSwaps("cba", Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2))));
    Assert.assertEquals("bcad", s.smallestStringWithSwaps("dcab", Arrays.asList(Arrays.asList(0, 3))));

  }
}
