package shuwei.leetcode.cn.nine;

import org.junit.Assert;
import org.junit.Test;

/** 
* @author shuwei 
* @version 创建时间：2020年4月22日 下午7:46:05 
* 类说明 
*/
public class SolutionTest {
  @Test
  public void test1() {
    Solution s = new Solution();
    Assert.assertEquals(true, s.isPalindrome(121));
    Assert.assertEquals(false, s.isPalindrome(-121));
    Assert.assertEquals(false, s.isPalindrome(10));
  }
}
