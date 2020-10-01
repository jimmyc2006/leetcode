package shuwei.shuwei.leetcode.cn.six.five.seven;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.judgeCircle("UD"));
    Assert.assertEquals(false, s.judgeCircle("LL"));
    Assert.assertEquals(true, s.judgeCircle("LUDR"));
  }

}
