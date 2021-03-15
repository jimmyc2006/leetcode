package shuwei.leetcode.cn.five.seven.zero.four;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(9732, s.maximumScore(new int[]{6569,9667,3148,7698,1622,2194,793,9041,1670,1872}, 5));
    Assert.assertEquals(15, s.maximumScore(new int[]{1,4,3,7,4,5}, 3));
    Assert.assertEquals(20, s.maximumScore(new int[]{5,5,4,5,4,1,1,1}, 0));
  }
}
