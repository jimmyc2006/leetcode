package shuwei.leetcode.cn.four.six.six;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author shuwei
 * @version 创建时间：2020年4月19日 下午6:28:59 类说明
 */
public class SolutionTest {
  @Test
  public void test() {
    Solution s = new Solution();
    Assert.assertEquals(2, s.getMaxRepetitions("bacaba", 3, "abacab", 1));
    Assert.assertEquals(2, s.getMaxRepetitions("acb", 5, "ab", 2));
    Assert.assertEquals(303,s.getMaxRepetitions(
        "phqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxf",
        1000000,
        "xtlsgypsfadpooefxzbcoejuvpvaboygpoeylfpbnpljvrvipyamyehwqnqrqpmxujjloovaowuxwhmsncbxcoksfzkvatxdknly",
        100));
    Assert.assertEquals(1,s.getMaxRepetitions("acb", 1 , "acb", 1));
    Assert.assertEquals(4, s.getMaxRepetitions("aaa", 3, "aa", 1));
    Assert.assertEquals(2, s.getMaxRepetitions("abc", 4, "ab", 2));
    Assert.assertEquals(7, s.getMaxRepetitions("baba", 11, "baab", 1));
    Assert.assertEquals(2, s.getMaxRepetitions("aahumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenazkycxf", 1000000, "aac", 1000000));
  }
}
