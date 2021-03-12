package shuwei.leetcode.cn.three.three.one;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.isValidSerialization("9,#,92,#,#"));
    Assert.assertEquals(true, s.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    Assert.assertEquals(false, s.isValidSerialization("1,#"));
    Assert.assertEquals(false, s.isValidSerialization("9,#,#,1"));
  }
}
