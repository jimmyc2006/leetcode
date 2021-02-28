package shuwei.leetcode.cn.one.one.seven.eight;

import org.junit.Test;

import java.util.Arrays;

import shuwei.leetcode.cn.TestUtil;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    TestUtil.assertList(Arrays.asList(1, 1, 3, 2, 4, 0), s.findNumOfValidWords(new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"},
            new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"}));
    TestUtil.assertList(Arrays.asList(1), s.findNumOfValidWords(new String[]{"aaaa"},
            new String[]{"aboveyz"}));
  }
}
