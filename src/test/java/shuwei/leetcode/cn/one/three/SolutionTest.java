package shuwei.leetcode.cn.one.three;

import org.junit.Test;

/** 
* @author shuwei 
* @version 创建时间：2020年4月22日 下午7:14:18 
* 类说明 
*/
public class SolutionTest {
  @Test
  public void test1() {
    Solution s = new Solution();
    System.out.println(s.romanToInt("III"));
    System.out.println(s.romanToInt("IV"));
    System.out.println(s.romanToInt("IX"));
    System.out.println(s.romanToInt("LVIII"));
    System.out.println(s.romanToInt("MCMXCIV"));
  }
}
