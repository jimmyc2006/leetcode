package shuwei.leetcode.cn.nine.five.nine;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(2, s.regionsBySlashes(new String[]{" /", "/ "}));
    Assert.assertEquals(2, s.regionsBySlashes(new String[]{"/"}));
    Assert.assertEquals(4, s.regionsBySlashes(new String[]{"\\\\/", "/\\\\"}));
    Assert.assertEquals(5, s.regionsBySlashes(new String[]{"/\\", "\\/"}));
    Assert.assertEquals(3, s.regionsBySlashes(new String[]{"//", "/ "}));
  }
}
