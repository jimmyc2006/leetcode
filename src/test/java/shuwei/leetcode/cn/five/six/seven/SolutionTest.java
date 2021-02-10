package shuwei.leetcode.cn.five.six.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.checkInclusion("adc", "dcda"));
    Assert.assertEquals(true, s.checkInclusion("abeeef", "eeeeeafeeboo"));
    Assert.assertEquals(true, s.checkInclusion("a", "a"));
    Assert.assertEquals(true, s.checkInclusion("ab", "eidbaooo"));
    Assert.assertEquals(false, s.checkInclusion("ab", "eidboaoo"));
  }
}
