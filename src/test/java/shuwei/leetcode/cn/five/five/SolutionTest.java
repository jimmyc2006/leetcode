package shuwei.leetcode.cn.five.five;

import org.junit.Assert;
import org.junit.Test;

/** 
* @author shuwei 
* @version 创建时间：2020年4月17日 上午9:23:07 
* 类说明 
*/
public class SolutionTest {
  @Test
  public void test1() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.canJump(new int[]{2,3,1,1,4}));
    Assert.assertEquals(false, s.canJump(new int[] {3,2,1,0,4}));
    Assert.assertEquals(true, s.canJump(new int[] {0}));
  }
}
