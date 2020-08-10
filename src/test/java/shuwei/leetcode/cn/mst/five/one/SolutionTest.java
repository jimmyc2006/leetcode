package shuwei.leetcode.cn.mst.five.one;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author shuwei
 * @version 创建时间：2020年4月24日 下午6:21:10 类说明
 */
public class SolutionTest {

  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(5, s.reversePairs(new int[] {2, 4, 3, 5, 1}));
    Assert.assertEquals(5, s.reversePairs(new int[] {7, 5, 6, 4}));
    Assert.assertEquals(4, s.reversePairs(new int[] {1, 3, 2, 3, 1}));
    Assert.assertEquals(0, s.reversePairs(new int[] {}));
  }
}
