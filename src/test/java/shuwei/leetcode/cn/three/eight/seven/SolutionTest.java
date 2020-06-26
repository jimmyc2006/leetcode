package shuwei.leetcode.cn.three.eight.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(0, s.firstUniqChar("leetcode"));
    Assert.assertEquals(2, s.firstUniqChar("loveleetcode"));
    Assert.assertEquals(-1, s.firstUniqChar("cc"));
  }
}
