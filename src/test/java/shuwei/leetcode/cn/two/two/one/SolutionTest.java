package shuwei.leetcode.cn.two.two.one;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(4, s.maximalSquare(new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
        { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } }));

  }

  @Test
  public void test2() {
    Solution s = new Solution();
    Assert.assertEquals(9, s.maximalSquare(new char[][] { { '0', '0', '0', '1' }, { '1', '1', '0', '1' },
        { '1', '1', '1', '1' }, { '0', '1', '1', '1' }, { '0', '1', '1', '1' } }));

  }

}
