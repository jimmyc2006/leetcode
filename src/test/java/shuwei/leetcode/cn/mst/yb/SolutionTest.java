package shuwei.leetcode.cn.mst.yb;

import org.junit.Assert;
import org.junit.Test;


/** 
* @author shuwei 
* @version 创建时间：2020年4月23日 上午9:16:04 
* 类说明 
*/
public class SolutionTest {
  @Test
  public void test1() {
    Solution s = new Solution();
    Assert.assertEquals(2, s.waysToChange(5));
    Assert.assertEquals(504188296, s.waysToChange(900750));
  }
  
  @Test
  public void test2() {
    Solution s = new Solution();
//    System.out.println(s.waysToChange(5));
//    System.out.println(s.waysToChange(10));
    System.out.println(s.waysToChange(900750));
  }
}
