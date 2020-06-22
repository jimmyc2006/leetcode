package shuwei.leetcode.cn.mst.one.six.one.eight;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.patternMatching("abba", "dogcatcatdog"));
    Assert.assertEquals(false, s.patternMatching("abba", "dogcatcatfish"));
    Assert.assertEquals(false, s.patternMatching("aaaa", "dogcatcatdog"));
    Assert.assertEquals(true, s.patternMatching("abba", "dogdogdogdog"));
    Assert.assertEquals(false, s.patternMatching("ab", ""));
  }
}
